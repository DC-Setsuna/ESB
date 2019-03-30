<template>
  <div class="log">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item><i class="el-icon-menu"></i>日志</el-breadcrumb-item>
        <el-breadcrumb-item>日志查询</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <el-collapse value="1">
      <el-collapse-item name="1">
        <template slot="title">
          日志查询选项<i class="el-icon-search"></i>
        </template>
        <div>
          <el-form :inline="true" :model="filter" size="mini">
            <el-form-item label="时间">
              <el-date-picker v-model="filter.LOG_TIMESTAMP" type="datetimerange" :picker-options="pickerOptions" format="yyyy-MM-dd HH:mm:ss"  value-format="yyyy-MM-dd HH:mm:ss" range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期" align="right">
              </el-date-picker>
            </el-form-item>
            <div>
              <el-form-item label="服务接收平台">
                <el-select v-model="filter.receiver_org">
                  <el-option v-for="item in this.$store.state.platform" :label="item.label" :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="服务接收系统">
                <el-select v-model="filter.receiver">
                  <el-option v-for="item in this.$store.state.system.MDXP" :label="item.label" :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </div>
            <div>
              <el-form-item label="服务发送平台">
                <el-select v-model="filter.sender_org">
                  <el-option v-for="item in this.$store.state.platform" :label="item.label" :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="服务发送系统">
                <el-select v-model="filter.sender">
                  <el-option v-for="item in this.$store.state.system.MDXP" :label="item.label" :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </div>
            <div>
              <el-form-item>
                <el-switch v-model="filter.showError" active-text="不包含错误信息" inactive-text="所有日志记录">
                </el-switch>
              </el-form-item>
              <el-form-item style="margin-left: 28px;">
                <el-button @click="clear">清空过滤项</el-button>
              </el-form-item>
            </div>
            <div>
              <el-button @click="getData" type="primary" icon="el-icon-search">搜索</el-button>
            </div>
          </el-form>
        </div>
      </el-collapse-item>
    </el-collapse>
    <el-table :data="tableVisibleData" border style="width: 100%" ref="multipleTable" @selection-change="handleSelectionChange">
      <el-table-column prop="log_TIMESTAMP" label="记录时间" width="180"></el-table-column>
      <el-table-column prop="sender_ORG" label="发送平台"></el-table-column>
      <el-table-column prop="sender" label="发送者"></el-table-column>
      <el-table-column prop="receiver_ORG" label="接收平台"></el-table-column>
      <el-table-column prop="receiver" label="接收者"></el-table-column>
      <el-table-column prop="service_CODE" label="服务编号" width="200"></el-table-column>
      <el-table-column label="操作" width="80" fixed="right" :resizable="false">
        <template scope="scope">
          <el-button size="mini" @click="handleDetail(scope.$index, scope.row)">详情</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="pagination">
      <el-pagination @current-change="handleCurrentChange" layout="prev, pager, next" :total="total" :page-size="10">
      </el-pagination>
    </div>
    <el-dialog title="日志详情" :visible.sync="detailVisible" :modal="false" custom-class="edit-dialog" width="800px">
      <div class="detail-row detail1">
        <span class="detail-row-1"><span>请求平台：</span><span>{{ detailData.sender_org }}</span></span>
        <span class="detail-row-2"><span>请求系统：</span><span>{{ detailData.sender }}</span></span>
      </div>
      <div class="detail-row detail2">
        <span class="detail-row-1"><span>接收平台：</span><span>{{ detailData.receiver_org }}</span></span>
        <span class="detail-row-2"><span>接收系统：</span><span>{{ detailData.receiver }}</span></span>
      </div>
      <div class="detail-row detail1">
        <span class="detail-row-1"><span>服务编号：</span><span>{{ detailData.service_code }}</span></span>
        <span class="detail-row-2"><span>服务版本：</span><span>{{ detailData.service_version }}</span></span>
      </div>
      <div class="detail-row detail2">
        <span class="detail-row-1"><span>请求时间：</span><span>{{ detailData.requestDate }}</span></span>
        <span class="detail-row-2"><span v-if="detailData.isSuccess"><span>响应时间：</span><span>{{ detailData.responseDate }}</span></span>
        <span v-else><span>错误时间：</span><span>{{ detailData.responseDate }}</span></span></span>
      </div>
      <div style="height: 250px;">
      	<div class="detail-msg detail-msg-1">
      	<div>请求报文：</div>
      	<div class="detail-msg-content"><pre>{{ detailData.requestMsg }}</pre></div>
      </div>
      <div class="detail-msg detail-msg-2">
      	<div>响应报文：</div>
      	<div class="detail-msg-content"><pre>{{ detailData.responseMsg }}</pre></div>
      </div>
      </div>
      
    </el-dialog>
  </div>
</template>
<script>
export default {
  data() {
    return {
      api: this.$store.state.api + '/api/msgflow',
      filter: {
        LOG_TIMESTAMP: '',
        showError: false,
        sender_org: '',
        sender: '',
        receiver_org: '',
        receiver: ''
      },
      form: {
        mindate: '',
        maxdate: '',
        sender_org: '',
        sender: '',
        receiver_org: '',
        receiver: '',
        type: false,
        page:'1'
      },
      tableData: [],
      tableVisibleData: [],
      total: 0,
      cur_page: 1,
      detailVisible: false,
      detailData: {
        sender_org: '',
        sender: '',
        receiver_org: '',
        receiver: '',
        service_code: '',
        service_version: '',
        requestDate: '',
        responseDate: '',
        requestMsg: '',
        responseMsg: '',
        isSuccess: true
      },
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
      this.axios.post(this.api + '/selectmsg', this.form).then((response) => {
        console.log(response.data);
        this.tableVisibleData = response.data.data;
        if(this.tableVisibleData != '' || this.tableVisibleData != null){
          for (let i = 0;i < this.tableVisibleData.length;i++)
            this.tableVisibleData[i].log_TIMESTAMP = this.tableVisibleData[i].log_TIMESTAMP.substring(0,19)
        }
        this.total = response.data.number;
        // this.setVisibleData();
      })
    },
    handleSelectionChange() {

    },
    handleDetail(index, row) {
      // var loading = this.$loading({
      //     lock: true,
      //     text: '正在拉取日志详情',
      //     spinner: 'el-icon-loading',
      //     background: 'rgba(0, 0, 0, 0.7)'
      //   });
      this.axios.post(this.api + '/selectmsgbynumber', { serial_number: row.serial_NUMBER }).then((response) => {
        // loading.close();
        this.detailVisible = true;
        var datas = response.data.data;
        this.detailData.sender_org = datas[0].sender_ORG;
        this.detailData.sender = datas[0].sender;
        this.detailData.receiver_org = datas[0].receiver_ORG;
        this.detailData.receiver = datas[0].receiver;
        this.detailData.service_code = datas[0].service_CODE;
        this.detailData.service_version = datas[0].service_VERSION;
        if (datas[0].msg_TYPE === 1) {
          this.detailData.requestDate = datas[0].log_TIMESTAMP;
          this.detailData.responseDate = datas[1].log_TIMESTAMP;
          this.detailData.requestMsg = datas[0].msg;
          this.detailData.responseMsg = datas[1].msg;
        } else {
          this.detailData.requestDate = datas[1].log_TIMESTAMP;
          this.detailData.responseDate = datas[0].log_TIMESTAMP;
          this.detailData.requestMsg = datas[1].msg;
          this.detailData.responseMsg = datas[0].msg;
        }
        if (datas[0].msg_TYPE === 3 || datas[1].msg_TYPE === 3) {
          this.detailData.isSuccess = false;
        }
        // this.detailVisible = true;

      }).catch(error => {
        // loading.close()
      })
    },
    handleCurrentChange(val) {
      this.form.page = val
      this.getData()
    },
    // setVisibleData() {
    //   var start = 10 * (this.cur_page - 1) + 1;
    //   var end = 10 * this.cur_page;
    //   var data = []
    //   for (let i = 0; i < this.tableData.length; i++) {
    //     if (i >= (start - 1) && i <= (end - 1)) {
    //       data.push(this.tableData[i])
    //     }
    //   }
    //   this.tableVisibleData = data;
    // },
    clear() {
      this.filter['LOG_TIMESTAMP'] = '',
      this.filter['sender_org'] = '',
      this.filter['sender'] = '',
      this.filter['receiver_org'] = '',
      this.filter['receiver'] = ''
    }
  },
  watch: {
    filter: {
      handler: function(val, oldVal) {
        this.form.mindate = this.filter.LOG_TIMESTAMP[0] || '';
        this.form.maxdate = this.filter.LOG_TIMESTAMP[1] || '';
        this.form.sender_org = this.filter.sender_org;
        this.form.sender = this.filter.sender;
        this.form.receiver_org = this.filter.receiver_org;
        this.form.receiver = this.filter.receiver;
        this.form.type = this.filter.showError;
      },
      deep: true
    },
    cur_page: function() {
      this.setVisibleData();
    }
  }
}

</script>
<style>
.crumbs {
  margin-bottom: 20px;
}

.pagination {
  margin: 20px 0;
  text-align: right;
}

.detail-row {
  height: 30px;
  font-size: 12px;
  line-height: 30px;
  padding-left: 20px;
}

.detail1 {
  background-color: #abedbb;;
}

.detail2 {
	background-color: #fff;
}

.detail-row-1 {
	display: inline-block;
	width: 50%;
}

.detail-row-2 {
	display: inline-block;
}

.detail-msg {
	display: inline-block;
	width: 46%;
	height: 200px;
  font-size: 12px;
  padding-left: 20px;
}

.detail-msg-1 {
	float: left;
}

.detail-msg-2 {
	float: right;
}

.detail-msg-content {
	border: 1px solid #eee;
	height: 100%;
	overflow: auto;
}
</style>
