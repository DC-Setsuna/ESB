<template>
  <div class="mq-admin">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item><i class="el-icon-location"></i>MQ监控</el-breadcrumb-item>
        <el-breadcrumb-item>综合管理平台</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <el-collapse v-model="activeNames">
      <el-collapse-item name="1">
        <template slot="title">
          Local Queue Managers<i class="header-icon el-icon-info"></i>
        </template>
        <div style="padding-left: 20px;">
        	<table width="500" cellspacing="0" cellpadding="3">
        	<tr align="left" style="background-color:#eee;">
        		<th>name</th>
        		<th>status</th>
        	</tr>
        	<tr>
        		<td>{{ qmgr.name }}</td>
        		<td v-if="this.qmgr.status == 'running'" style="color: #0cdb1e;"><i class="el-icon-loading"></i>Running</td>
                <td v-else>disable</td>
        	</tr>
        </table>
        </div>
        
      </el-collapse-item>
      <el-collapse-item title="Listeners 监听器" name="2">
        <div style="padding-left:20px;">
        	<table width="500" cellspacing="0" cellpadding="3">
        		<tr align="left" style="background-color:#eee;">
        			<th>Name</th>
        			<th>Port</th>
        			<th>Listener Status</th>
        		</tr>
        		<tr>
        			<td>{{listener.name}}</td>
        			<td>{{listener.port}}</td>
                    <td v-if="this.listener.status == 'running'" style="color: #0cdb1e;"><i class="el-icon-loading"></i>Running</td>
                <td v-else>disable</td>
        		</tr>
        	</table>
        </div>
      </el-collapse-item>
      <el-collapse-item title="Queue" name="3">
        <!-- <div style="padding-left:20px;">
        	<table width="500" cellspacing="0" cellpadding="3">
        		<tr align="left" style="background-color:#eee;">
        			<th>Name</th>
        			<th>Type</th>
        			<th>Depth</th>
        		</tr>
        		<tr v-for="item in queue">
        			<td>{{item.name}}</td>
        			<td>{{item.type}}</td>
        			<td>{{item.currentdepth}}</td>
        		</tr>
        	</table>
        </div> -->
        <el-table :data="queueVisible" border style="width: 100%" ref="multipleTable">
            <el-table-column prop="name" label="Name"></el-table-column>
            <el-table-column prop="type" label="Type"></el-table-column>
            <el-table-column prop="currentdepth" label="CurrentDepth"></el-table-column>
        </el-table>
            <div class="pagination">
            <el-pagination @current-change="handleCurrentChange" layout="prev, pager, next" :total="total" :page-size="10">
            </el-pagination>
            </div>
      </el-collapse-item>
    </el-collapse>
  </div>
</template>
<script>
export default {
  data() {
    return {
        api: this.$store.state.api,
        qmgr: {
            name: '',
            status: ''
        },
        listener: {
            name: '',
            port: '',
            status: ''
        },
        queue: [],
        activeNames: ['1','2','3'],
        cur_page: 1,
        queueVisible: [],
        total:  0
    }
  },
  methods: {
    getManagers() {
        this.axios.get(this.api + '/api/Mqadmin/qmgr').then((response) => {
            this.qmgr.name = response.data.data[0]['name']
            if (response.data.data[0]['status'] === 'RUNNING') {
                this.qmgr.status = 'running'
            } else {
                this.qmgr.status = 'disabled'
            }
        })
    },
    getListeners() {
        this.axios.get(this.api + '/api/Mqadmin/qmgr/listener').then((response) => {
            this.listener.name = response.data.data[0]['name']
            this.listener.port = response.data.data[0]['port']
            if (response.data.data[0]['status'] === 'MQSVC_STATUS_RUNNING') {
                this.listener.status = 'running'
            } else {
                this.listener.status = 'disable'
            }
        })
    },
    getQueens() {
        this.axios.get(this.api + '/api/Mqadmin/qmgr/queue').then((response) => {
            this.queue = response.data.data
            this.total = this.queue.length;
            this.setVisibleData();
        })
    },
    handleCurrentChange(val) {
      this.cur_page = val;
      this.setVisibleData();
    },
    setVisibleData() {
        debugger;
      var start = 10 * (this.cur_page - 1) + 1;
      var end = 10 * this.cur_page;
      var data = []
      for (let i = 0; i < this.queue.length; i++) {
        if (i >= (start - 1) && i <= (end - 1)) {
          data.push(this.queue[i])
        }
      }
      this.queueVisible = data;
    },
  },
  created: function() {
    this.getManagers()
    this.getListeners()
    this.getQueens()
  }
}

</script>
<style>

.pagination {
  margin: 20px 0;
  text-align: right;
}
</style>
