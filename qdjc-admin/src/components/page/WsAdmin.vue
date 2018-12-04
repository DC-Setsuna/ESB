<template>
  <div class="mq-admin">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item><i class="el-icon-location"></i>WS监控</el-breadcrumb-item>
        <el-breadcrumb-item>接入平台管理</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <el-collapse value="1">
      <el-collapse-item name="1">
        <template slot="title">
          WS状态查询选项<i class="el-icon-search"></i>
        </template>
        <div>
          <el-form :inline="true" :model="filter" size="mini">
            <div>
              <el-form-item label="平台名称">
                <el-select v-model="filter.platform">
                  <el-option v-for="item in this.$store.state.platform" :label="item.label" :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="服务编码">
                <el-input v-model="filter.service_code"></el-input>
              </el-form-item>
            </div>
            <div>
              <el-form-item label="时间">
                <el-date-picker v-model="filter.time" type="datetimerange" :picker-options="pickerOptions" range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期" align="right">
                </el-date-picker>
              </el-form-item>
            </div>
            <div>
              <el-button @click="getData" type="primary" icon="el-icon-search">搜索</el-button>
            </div>
          </el-form>
        </div>
      </el-collapse-item>
    </el-collapse>
    <el-table :data="tableData" border style="width: 100%" ref="multipleTable">
      <el-table-column prop="platform" label="接入平台"></el-table-column>
      <el-table-column prop="service_code" label="服务编码"></el-table-column>
      <el-table-column prop="count" label="调用总数"></el-table-column>
      <el-table-column prop="success" label="成功调用次数"></el-table-column>
      <el-table-column prop="fail" label="失败调用次数"></el-table-column>
      <el-table-column prop="rate" label="调用失败比例"></el-table-column>
      <el-table-column prop="last" label="最近一次调用状态"></el-table-column>
      <el-table-column prop="last_time" label="最近一次调用成功时间"></el-table-column>
      <el-table-column prop="last_fail" label="最近一次调用失败时间"></el-table-column>
    </el-table>
  </div>
</template>
<script>
export default {
  data() {
    return {
      filter: {
        platform: '',
        service_code: '',
        time: []
      },
      tableData: [],
      tableVisibleData: [],
      pickerOptions: {
        shortcuts: [{
          text: '最近一周',
          onClick(picker) {
            const end = new Date();
            const start = new Date();
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
            picker.$emit('pick', [start, end]);
          }
        }, {
          text: '最近一个月',
          onClick(picker) {
            const end = new Date();
            const start = new Date();
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
            picker.$emit('pick', [start, end]);
          }
        }, {
          text: '最近三个月',
          onClick(picker) {
            const end = new Date();
            const start = new Date();
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
            picker.$emit('pick', [start, end]);
          }
        }]
      }
    }
  },
  methods: {
    getData() {
      this.axios.get('../../../static/WS-data.json').then((response) => {
        this.tableData = response.data;
      })
    }
  }
}

</script>
<style>


</style>
