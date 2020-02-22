<template>
  <div id="app">
<!-- 
<el-container style="height: 500px; border: 1px solid #eee">
  <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
    <el-menu :default-openeds="['1', '3']" :default-active="'1-1'">
      <el-submenu index="1">
          <template slot="title"><i class="el-icon-setting"></i>分组一</template>
          <el-menu-item index="1-1">选项1</el-menu-item>
          <el-menu-item index="1-2">选项2</el-menu-item>
          <el-submenu index="1-3">
            <template slot="title"><i class="el-icon-setting"></i>选项3</template>
            <el-menu-item index="1-3-1">选项3-1</el-menu-item>
            <el-menu-item index="1-3-2">选项3-2</el-menu-item>
            </el-submenu>
      </el-submenu>
    </el-menu> -->
    <!-- <el-menu >
      <el-submenu v-for="(item,index) in $router.options.routes" :key="index" :index="index+''">
        <template slot="title"><i class="el-icon-setting"></i>{{item.name}}</template>
        <el-menu-item v-for="(item2,index2) in item.children" :key="index2" :index="index+'-'+index2">{{item2.name}}</el-menu-item>
      </el-submenu>
    </el-menu>
  </el-aside>
  
  <el-container>
    <el-header style="text-align: right; font-size: 12px">
      <el-dropdown>
        <i class="el-icon-setting" style="margin-right: 15px"></i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>查看</el-dropdown-item>
          <el-dropdown-item>新增</el-dropdown-item>
          <el-dropdown-item>删除</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <span>王小虎</span>
    </el-header>
    
    <el-main>
   
    </el-main>
  </el-container>
</el-container> -->
  
  
 
<el-container style="height: 500px; border: 1px solid #eee">
  <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
    <el-menu router :default-openeds="['0','1']">
      <el-submenu v-for="(item,index) in $router.options.routes" :key="index" :index="index+''" v-if="item.show">
 
        <template slot="title"><i class="el-icon-setting"></i>{{item.name}}</template>
        <el-menu-item v-for="(item2,index2) in item.children" :key="index2" :index="item2.path"
        :class="$route.path==item2.path?'is-active':''">{{item2.name}}</el-menu-item>
      
      </el-submenu>
    </el-menu>
  </el-aside>
  
  <el-container>
    <el-header style="text-align: right; font-size: 12px">
      <el-dropdown>
        <i class="el-icon-setting" style="margin-right: 15px"></i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>查看</el-dropdown-item>
          <el-dropdown-item>新增</el-dropdown-item>
          <el-dropdown-item>删除</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <span>王小虎</span>
    </el-header>
    
    <el-main>
   <router-view></router-view>
    </el-main>
  </el-container>
</el-container>


  </div>
</template>

<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }
  
  .el-aside {
    color: #333;
  }
</style>

<script>
  export default {
    data() {
      const item = {
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      };
      return {
        tableData: Array(20).fill(item)
      }
    }
  };
</script>