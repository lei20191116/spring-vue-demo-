<template>
  <div>
     <el-table
    :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
    style="width: 100%">
    <el-table-column
      label="id"
      prop="id">
    </el-table-column>
    <el-table-column
      label="姓名"
      prop="name">
    </el-table-column>
    <el-table-column
      label="密码"
      prop="password">
    </el-table-column>
    <el-table-column
      align="right">
      <template slot="header" slot-scope="scope">
        <el-input
          v-model="search"
          size="mini"
          placeholder="输入关键字搜索"/>
      </template>
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="Edit(scope.$index, scope.row)">编辑</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="Delete(scope.$index, scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  <!-- 分页 -->
  <el-pagination
  background
  layout="prev, pager, next"
  :page-size="pageSize"
  :total="total"
  @current-change="page">
</el-pagination>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        pageSize:1,
        total:11,
        tableData: [{
          id: '1',
          name: '王小虎',
          password: 'root'
        }, {
         id: '2',
          name: '小虎',
          password: 'root'
        }, {
          id: '3',
          name: '虎子',
          password: 'root'
        }, {
          id: '4',
          name: '王小虎',
          password: 'root'
        }],
        search: ''
      }
    },
    methods: {
      
      Edit(index, row) {
         this.$router.push({
           path:'/UserUpdate',
           query:{
             id:row.id
           }
         })
       //row.id
      },
      Delete(index, row) {
        const _this = this;
        axios.delete("http://localhost:8181/user/deleteById/"+row.id).then(function(resp){
               _this.$alert('《'+row.name+'》删除成功', '消息', {
                    confirmButtonText: '确定',
                    callback: action => {
                     window.location.reload();
                    }
                  });
        })
      },
      page(currentPage){
          const _this = this;
      axios.get('http://localhost:8181/user/findAll/'+(currentPage-1)+'/6').then(function(resp){
        _this.tableData = resp.data.content;
        _this.pageSize = resp.data.size;
        _this.total = resp.data.totalElements;
      })
    }
    },
    created(){
      const _this = this;
      axios.get('http://localhost:8181/user/findAll/0/6').then(function(resp){
        _this.tableData = resp.data.content;
        _this.pageSize = resp.data.size;
        _this.total = resp.data.totalElements;
      })
    }
  }
</script>