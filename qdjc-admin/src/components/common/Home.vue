<template>
    <div class="wrapper">
        <v-head></v-head>
        <v-sidebar></v-sidebar>
        <div class="content">
            <transition name="move" mode="out-in"><router-view></router-view></transition>
        </div>
    </div>
</template>

<script>
    import vHead from './Header.vue';
    import vSidebar from './Sidebar.vue';
    export default {
        components:{
            vHead, vSidebar
        }
    }
</script>
<style>
.content {
	position: fixed;
	top: 50px;
	left: 200px;
	width: calc(100% - 280px);
	height: calc(100% - 130px);
	padding: 40px;
	overflow: auto;
}
</style>