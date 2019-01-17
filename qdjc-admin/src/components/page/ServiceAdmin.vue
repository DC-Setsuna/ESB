<template>
  <div class="service-admin">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item><i class="el-icon-menu"></i>服务管理</el-breadcrumb-item>
        <el-breadcrumb-item>服务列表</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <el-button type="primary" icon="el-icon-refresh" @click="add">数据同步</el-button>
    <div style="display: inline-block; width: 300px;">
      <el-input v-model="select_word" placeholder="筛选关键词" id="service-handle-input"></el-input>
    </div>
    <el-button type="primary" icon="el-icon-search" @click="search">搜索</el-button>
    <br>
    <br>
    <el-table :data="tableVisibleData" border style="width: 100%" ref="multipleTable" @selection-change="handleSelectionChange">
      <el-table-column prop="pk_SERVICE" label="Service ID" width="240"></el-table-column>
      <el-table-column prop="service_CODE" label="服务编号"></el-table-column>
      <el-table-column prop="owner_ORG" label="所属平台"></el-table-column>
      <el-table-column prop="owner" label="服务名"></el-table-column>
      <el-table-column prop="type" label="服务类型"></el-table-column>
      <el-table-column label="操作" width="80" fixed="right" :resizable="false">
        <template scope="scope">
          <el-button size="mini" @click="handleDetail(scope.$index, scope.row)">详情</el-button>
          <!-- <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button> -->
        </template>
      </el-table-column>
    </el-table>
    <div class="pagination">
      <el-pagination @current-change="handleCurrentChange" layout="prev, pager, next" :total="total" :page-size="10">
      </el-pagination>
    </div>
    <el-dialog title="详细信息" :visible.sync="detailVisible" :modal="false">
      <table border="0" class="detail-message" cellspacing="3" cellpadding="3">
        <tr>
          <th> key </th>
          <th> value </th>
        </tr>
        <tr v-for="(value, key) in detail">
          <td width="230">
            {{detail_CN[key]}}
          </td>
          <td>{{value}}</td>
        </tr>
      </table>
      <span slot="footer">
    		<el-button type="primary" @click="detailVisible = false">确定</el-button>
    	</span>
    </el-dialog>
    <el-dialog title="新增服务" :visible.sync="addVisible" :modal="false">
      <el-form :model="addData" label-width="80px" :inline="true" size="mini">
        <el-form-item label="服务编号">
          <el-input v-model="addData.SERVICE_CODE"></el-input>
        </el-form-item>
        <el-form-item label="服务版本">
          <el-input v-model="addData.SERVICE_VERSION"></el-input>
        </el-form-item>
        <el-form-item label="所属平台">
          <el-select v-model="addData.OWNER_ORG">
            <el-option v-for="item in this.$store.state.platform" :label="item.label" :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="所属系统">
          <el-select v-model="addData.OWNER">
            <el-option v-for="item in this.$store.state.system.MDXP" :label="item.label" :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="服务类型">
          <el-select v-model="addData.TYPE">
            <el-option v-for="item in this.$store.state.serviceType" :label="item.label" :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="ENABLED">
          <el-select v-model="addData.ENABLED_FLAG">
            <el-option label="是" :value="1"></el-option>
            <el-option label="否" :value="0"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="说明信息">
          <div style="width: 450px">
            <el-input type="textarea" :rows="4" placeholder="请输入说明信息" v-model="addData.REMARK" size="medium">
            </el-input>
          </div>
        </el-form-item>
      </el-form>
      <span slot="footer">
				<el-button @click="addVisible = false">取消</el-button>
    		<el-button type="primary" @click="addItem">确定</el-button>
    	</span>
    </el-dialog>
    <el-dialog title="编辑服务" :visible.sync="editVisible" :modal="false">
      <!-- <table border="0" cellspacing="0">
        <tr v-for="(value, key) in editData">
          <td width="230">
            <el-tag type="success">{{key}}</el-tag>
          </td>
          <td>
            <el-input v-model="editData[key]"></el-input>
          </td>
        </tr>
      </table> -->
      <el-form :model="addData" label-width="80px" :inline="true" size="mini">
        <el-form-item label="服务编号">
          <el-input v-model="editData.SERVICE_CODE"></el-input>
        </el-form-item>
        <el-form-item label="服务版本">
          <el-input v-model="editData.SERVICE_VERSION"></el-input>
        </el-form-item>
        <el-form-item label="所属平台">
          <el-select v-model="editData.OWNER_ORG">
            <el-option v-for="item in this.$store.state.platform" :label="item.label" :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="所属系统">
          <el-select v-model="editData.OWNER">
            <el-option v-for="item in this.$store.state.system.MDXP" :label="item.label" :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="服务类型">
          <el-select v-model="editData.TYPE">
            <el-option v-for="item in this.$store.state.serviceType" :label="item.label" :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="ENABLED">
          <el-select v-model="editData.ENABLED_FLAG">
            <el-option label="是" value="1"></el-option>
            <el-option label="否" value="0"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="说明信息">
          <div style="width: 450px">
            <el-input type="textarea" :rows="4" placeholder="请输入说明信息" v-model="editData.REMARK" size="medium">
            </el-input>
          </div>
        </el-form-item>
      </el-form>
      <span slot="footer">
				<el-button @click="editVisible = false">取消</el-button>
    		<el-button type="primary" @click="editItem">确定</el-button>
    	</span>
    </el-dialog>
  </div>
</template>
<script>
export default {
  data() {
    return {
      api: this.$store.state.api + '/api/service',
      tableData: [],
      tableVisibleData: [],
      cur_page: 1,
      select_word: '',
      detail: {},
      detailVisible: false,
      addData: {
        SERVICE_CODE: "",
        SERVICE_VERSION: "1.0",
        OWNER_ORG: "",
        OWNER: "",
        TYPE: "",
        ENABLED_FLAG: "",
        REMARK: ""
      },
      addVisible: false,
      total: 0,
      editData: {
        SERVICE_CODE: "",
        SERVICE_VERSION: "",
        OWNER_ORG: "",
        OWNER: "",
        TYPE: "",
        ENABLED_FLAG: "",
        REMARK: ""
      },
      editVisible: false,
      editID: '',
      detail_CN: {
        'REMARK': '备注',
        'insert_TIMESTAMP': '插入时间',
        'last_UPDATE_TIMESTAMP': '上次更新时间',
        'pk_SERVICE': '数据库主键ID',
        'type': '服务类型',
        'owner_ORG': '所属平台',
        'owner': '所属系统',
        'service_CODE': '服务编号',
        'service_VERSION': '服务版本',
        'creator': '创建者',
        'enabled_FLAG': '是否可用(1为可用，0为不可用)',
        'remark': '备注',
        'modifier': '修改者'
      }
    }
  },
  methods: {
    getData() {
      this.axios.get(this.api + '/select-all').then((response) => {
        this.tableData = response.data.data;
        console.log(this.tableData);
        this.setVisibleData();
      })
    },
    add() {
      // this.addVisible = true;
      const loading = this.$loading({
          lock: true,
          text: '数据同步中',
          spinner: 'el-icon-loading',
          background: 'rgba(0, 0, 0, 0.7)'
        });
        // setTimeout(() => {
        //   loading.close();
        // }, 2000);
        this.axios.get(this.$store.state.api + '/sync-service').then((response) => {
          loading.close()
          this.$notify({
            title: '同步成功',
            message: '受影响数据条数为：'+response.data.count,
            duration: 3000
          });
          this.getData()
          this.getPage()
        }).catch((error) => {
          loading.close()
          this.$notify({
            title: '同步失败',
            message: '检查接口是否可用',
            duration: 3000
          });
        })
    },
    search() {
      this.axios.get(this.api + '/selectservicebycondition', { params: { key: this.select_word.toUpperCase() } }).then((response) => {
        this.tableData = response.data.data;
        this.total = response.data.data.length;
        this.cur_page = 1;
        this.setVisibleData();
      })
    },
    handleSelectionChange() {

    },
    handleEdit(index, row) {
      this.editID = row.pk_SERVICE;
      this.editData['SERVICE_CODE'] = row.service_CODE;
      this.editData['SERVICE_VERSION'] = row.service_VERSION;
      this.editData['OWNER_ORG'] = row.owner_ORG;
      this.editData['OWNER'] = row.owner;
      this.editData['TYPE'] = row.type;
      this.editData['ENABLED_FLAG'] = row.enabled_FLAG;
      this.editData['REMARK'] = row.remark;
      this.editVisible = true;
    },
    handleDelete(index, row) {
      this.$confirm('此操作将删除该条记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios({
            method: 'delete',
            url: this.api + '/delete',
            data: row
          }).then((response) => {
            if (response.data.code === 200) {
              this.getPage();
              this.getData();
              this.$message({
                message: '删除成功!',
                type: 'success'
              })
            }
            if (response.data.code === 400) {
              this.$message.error('删除出现错误！');
            }
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
      })
    },
    handleDetail(index, row) {
      this.detail = row;
      this.detailVisible = true;
    },
    addItem() {
      this.axios.post(this.api + '/add', this.addData).then((response) => {
        if (response.data.code === 200) {
          this.getPage();
          this.getData();
          this.$message({
            message: '新增成功',
            type: 'success'
          });
          this.initData(this.addData);
        }
        if (response.data.code === 400) {
          this.$message.error('新增出现问题');
        }
      })
      this.getData();
      this.addVisible = false;
    },
    handleCurrentChange(val) {
      this.cur_page = val;
      //this.getData();
    },
    getPage() {
      this.axios.get(this.api + '/selectpageamount').then((response) => {
        this.total = response.data.data;
      })
    },
    setVisibleData() {
      var start = 10 * (this.cur_page - 1) + 1;
      var end = 10 * this.cur_page;
      var data = []
      for (let i = 0; i < this.tableData.length; i++) {
        if (i >= (start - 1) && i <= (end - 1)) {
          data.push(this.tableData[i])
        }
      }
      this.tableVisibleData = data;
    },
    editItem() {
      this.editData.PK_SERVICE = this.editID;
      this.axios.post(this.api + '/update', this.editData).then((response) => {
        if (response.data.code === 200) {
          this.getData();
          this.$message({ message: '修改成功', type: 'success' });
        }
        if (response.data.code === 400) {
          this.$message.error('更新出现问题');
        }
        this.editVisible = false;
      })
    },
    initData(data) {
      for (let i in data) {
        data[i] = '';
      }
    }
  },
  created: function() {
    this.getData();
    this.getPage();
  },
  watch: {
    cur_page: function() {
      console.log(this.cur_page);
      this.setVisibleData();
    }
  }
}

</script>
<style>
.crumbs {
  margin-bottom: 20px;
}

#service-handle-input {
  width: 300px;
  display: inline-block;
}

.pagination {
  margin: 20px 0;
  text-align: right;
}

.detail-message {
  border: 1px solid #ddd;
  margin: 0 auto;
}

.detail-message tr td{
  border-bottom: 1px solid #ddd;
}

.detail-message th{
  border-bottom: 1px solid black;
  text-align: left;
  background-color: #409EFF;
  color: #fff;
}

</style>
