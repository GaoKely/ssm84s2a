<template>
<view class="content">
	<view class="box" :style='{"padding":"30rpx 24rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0 2%","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0.3)","borderRadius":"0","borderWidth":"0","width":"calc(100% - 4%)","borderStyle":"solid","height":"auto"}'>
		<view :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xuesheng'" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}'>学号</view>
			<input disabled="true"  style="padding: 0 30upx" :style='{"padding":"0 24rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(220, 220, 220, 1)","backgroundColor":"rgba(0,0,0,0)","color":"red","borderRadius":"88rpx","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"24rpx","borderStyle":"solid","height":"auto"}' v-model="ruleForm.xuehao" placeholder="学号"></input>
		</view>
		<view :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xuesheng'" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}'>密码</view>
			<input  type="password" style="padding: 0 30upx" :style='{"padding":"0 24rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(220, 220, 220, 1)","backgroundColor":"rgba(0,0,0,0)","color":"red","borderRadius":"88rpx","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"24rpx","borderStyle":"solid","height":"auto"}' v-model="ruleForm.mima" placeholder="密码"></input>
		</view>
		<view :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xuesheng'" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}'>学生姓名</view>
			<input   style="padding: 0 30upx" :style='{"padding":"0 24rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(220, 220, 220, 1)","backgroundColor":"rgba(0,0,0,0)","color":"red","borderRadius":"88rpx","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"24rpx","borderStyle":"solid","height":"auto"}' v-model="ruleForm.xueshengxingming" placeholder="学生姓名"></input>
		</view>
		<view :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xuesheng'" @tap="xueshengzhaopianTap" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}'>照片</view>
			<view style="flex: 1;">
				<image :style='{"padding":"0","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"100%","borderWidth":"0","width":"104rpx","borderStyle":"solid","height":"104rpx"}' v-if="ruleForm.zhaopian" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.zhaopian" mode=""></image>
				<image :style='{"padding":"0","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"100%","borderWidth":"0","width":"104rpx","borderStyle":"solid","height":"104rpx"}' v-else class="avator" style="margin: 0;" src="../../static/center/face.jpeg" mode=""></image>
			</view>
		</view>
			<view v-if="tableName=='xuesheng'" :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' class="cu-form-group select">
                                <view :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}' class="title">性别</view>
                                <picker  @change="xueshengxingbieChange" :value="xueshengxingbieIndex" :range="xueshengxingbieOptions">
                                        <view style="padding: 0 30upx" :style='{"padding":"0 20rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","margin":"0","borderColor":"rgba(220, 220, 220, 1)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderRadius":"56rpx","borderWidth":"2rpx","width":"calc(100% - 120rpx)","fontSize":"28rpx","borderStyle":"solid","height":"52rpx"}' class="uni-input picker-select-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
                                </picker>
                        </view>
		<view :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xuesheng'" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}'>联系方式</view>
			<input   style="padding: 0 30upx" :style='{"padding":"0 24rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(220, 220, 220, 1)","backgroundColor":"rgba(0,0,0,0)","color":"red","borderRadius":"88rpx","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"24rpx","borderStyle":"solid","height":"auto"}' v-model="ruleForm.lianxifangshi" placeholder="联系方式"></input>
		</view>
		<view :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xuesheng'" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}'>院系</view>
			<input   style="padding: 0 30upx" :style='{"padding":"0 24rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(220, 220, 220, 1)","backgroundColor":"rgba(0,0,0,0)","color":"red","borderRadius":"88rpx","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"24rpx","borderStyle":"solid","height":"auto"}' v-model="ruleForm.yuanxi" placeholder="院系"></input>
		</view>
		<view :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xuesheng'" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}'>年级</view>
			<input   style="padding: 0 30upx" :style='{"padding":"0 24rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(220, 220, 220, 1)","backgroundColor":"rgba(0,0,0,0)","color":"red","borderRadius":"88rpx","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"24rpx","borderStyle":"solid","height":"auto"}' v-model="ruleForm.nianji" placeholder="年级"></input>
		</view>
			<view v-if="tableName=='xuesheng'" :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' class="cu-form-group select">
                                <view :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}' class="title">教师工号</view>
                                <picker  @change="xueshengjiaoshigonghaoChange" :value="xueshengjiaoshigonghaoIndex" :range="xueshengjiaoshigonghaoOptions">
                                        <view style="padding: 0 30upx" :style='{"padding":"0 20rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","margin":"0","borderColor":"rgba(220, 220, 220, 1)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderRadius":"56rpx","borderWidth":"2rpx","width":"calc(100% - 120rpx)","fontSize":"28rpx","borderStyle":"solid","height":"52rpx"}' class="uni-input picker-select-input">{{ruleForm.jiaoshigonghao?ruleForm.jiaoshigonghao:"请选择教师工号"}}</view>
                                </picker>
                        </view>
		<view :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jiaoshi'" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}'>教师工号</view>
			<input disabled="true"  style="padding: 0 30upx" :style='{"padding":"0 24rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(220, 220, 220, 1)","backgroundColor":"rgba(0,0,0,0)","color":"red","borderRadius":"88rpx","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"24rpx","borderStyle":"solid","height":"auto"}' v-model="ruleForm.jiaoshigonghao" placeholder="教师工号"></input>
		</view>
		<view :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jiaoshi'" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}'>密码</view>
			<input  type="password" style="padding: 0 30upx" :style='{"padding":"0 24rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(220, 220, 220, 1)","backgroundColor":"rgba(0,0,0,0)","color":"red","borderRadius":"88rpx","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"24rpx","borderStyle":"solid","height":"auto"}' v-model="ruleForm.mima" placeholder="密码"></input>
		</view>
		<view :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jiaoshi'" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}'>教师姓名</view>
			<input   style="padding: 0 30upx" :style='{"padding":"0 24rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(220, 220, 220, 1)","backgroundColor":"rgba(0,0,0,0)","color":"red","borderRadius":"88rpx","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"24rpx","borderStyle":"solid","height":"auto"}' v-model="ruleForm.jiaoshixingming" placeholder="教师姓名"></input>
		</view>
		<view :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jiaoshi'" @tap="jiaoshizhaopianTap" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}'>照片</view>
			<view style="flex: 1;">
				<image :style='{"padding":"0","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"100%","borderWidth":"0","width":"104rpx","borderStyle":"solid","height":"104rpx"}' v-if="ruleForm.zhaopian" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.zhaopian" mode=""></image>
				<image :style='{"padding":"0","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"100%","borderWidth":"0","width":"104rpx","borderStyle":"solid","height":"104rpx"}' v-else class="avator" style="margin: 0;" src="../../static/center/face.jpeg" mode=""></image>
			</view>
		</view>
			<view v-if="tableName=='jiaoshi'" :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' class="cu-form-group select">
                                <view :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}' class="title">性别</view>
                                <picker  @change="jiaoshixingbieChange" :value="jiaoshixingbieIndex" :range="jiaoshixingbieOptions">
                                        <view style="padding: 0 30upx" :style='{"padding":"0 20rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","margin":"0","borderColor":"rgba(220, 220, 220, 1)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderRadius":"56rpx","borderWidth":"2rpx","width":"calc(100% - 120rpx)","fontSize":"28rpx","borderStyle":"solid","height":"52rpx"}' class="uni-input picker-select-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
                                </picker>
                        </view>
			<view v-if="tableName=='jiaoshi'" :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' class="cu-form-group select">
                                <view :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}' class="title">职称</view>
                                <picker  @change="jiaoshizhichengChange" :value="jiaoshizhichengIndex" :range="jiaoshizhichengOptions">
                                        <view style="padding: 0 30upx" :style='{"padding":"0 20rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","margin":"0","borderColor":"rgba(220, 220, 220, 1)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderRadius":"56rpx","borderWidth":"2rpx","width":"calc(100% - 120rpx)","fontSize":"28rpx","borderStyle":"solid","height":"52rpx"}' class="uni-input picker-select-input">{{ruleForm.zhicheng?ruleForm.zhicheng:"请选择职称"}}</view>
                                </picker>
                        </view>
		<view :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jiaoshi'" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}'>联系电话</view>
			<input   style="padding: 0 30upx" :style='{"padding":"0 24rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(220, 220, 220, 1)","backgroundColor":"rgba(0,0,0,0)","color":"red","borderRadius":"88rpx","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"24rpx","borderStyle":"solid","height":"auto"}' v-model="ruleForm.lianxidianhua" placeholder="联系电话"></input>
		</view>
		<view :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='shezhang'" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}'>社长账号</view>
			<input disabled="true"  style="padding: 0 30upx" :style='{"padding":"0 24rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(220, 220, 220, 1)","backgroundColor":"rgba(0,0,0,0)","color":"red","borderRadius":"88rpx","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"24rpx","borderStyle":"solid","height":"auto"}' v-model="ruleForm.shezhangzhanghao" placeholder="社长账号"></input>
		</view>
		<view :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='shezhang'" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}'>密码</view>
			<input  type="password" style="padding: 0 30upx" :style='{"padding":"0 24rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(220, 220, 220, 1)","backgroundColor":"rgba(0,0,0,0)","color":"red","borderRadius":"88rpx","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"24rpx","borderStyle":"solid","height":"auto"}' v-model="ruleForm.mima" placeholder="密码"></input>
		</view>
		<view :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='shezhang'" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}'>社长姓名</view>
			<input   style="padding: 0 30upx" :style='{"padding":"0 24rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(220, 220, 220, 1)","backgroundColor":"rgba(0,0,0,0)","color":"red","borderRadius":"88rpx","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"24rpx","borderStyle":"solid","height":"auto"}' v-model="ruleForm.shezhangxingming" placeholder="社长姓名"></input>
		</view>
		<view :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='shezhang'" @tap="shezhangtouxiangTap" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}'>头像</view>
			<view style="flex: 1;">
				<image :style='{"padding":"0","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"100%","borderWidth":"0","width":"104rpx","borderStyle":"solid","height":"104rpx"}' v-if="ruleForm.touxiang" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
				<image :style='{"padding":"0","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"100%","borderWidth":"0","width":"104rpx","borderStyle":"solid","height":"104rpx"}' v-else class="avator" style="margin: 0;" src="../../static/center/face.jpeg" mode=""></image>
			</view>
		</view>
			<view v-if="tableName=='shezhang'" :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' class="cu-form-group select">
                                <view :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}' class="title">性别</view>
                                <picker  @change="shezhangxingbieChange" :value="shezhangxingbieIndex" :range="shezhangxingbieOptions">
                                        <view style="padding: 0 30upx" :style='{"padding":"0 20rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","margin":"0","borderColor":"rgba(220, 220, 220, 1)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderRadius":"56rpx","borderWidth":"2rpx","width":"calc(100% - 120rpx)","fontSize":"28rpx","borderStyle":"solid","height":"52rpx"}' class="uni-input picker-select-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
                                </picker>
                        </view>
		<view :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='shezhang'" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}'>联系电话</view>
			<input   style="padding: 0 30upx" :style='{"padding":"0 24rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(220, 220, 220, 1)","backgroundColor":"rgba(0,0,0,0)","color":"red","borderRadius":"88rpx","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"24rpx","borderStyle":"solid","height":"auto"}' v-model="ruleForm.lianxidianhua" placeholder="联系电话"></input>
		</view>
		<view :style='{"padding":"8rpx 24rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"50rpx","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='shezhang'" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"120rpx","lineHeight":"52rpx","fontSize":"28rpx","borderStyle":"solid"}'>社团名称</view>
			<input   style="padding: 0 30upx" :style='{"padding":"0 24rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(220, 220, 220, 1)","backgroundColor":"rgba(0,0,0,0)","color":"red","borderRadius":"88rpx","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"24rpx","borderStyle":"solid","height":"auto"}' v-model="ruleForm.shetuanmingcheng" placeholder="社团名称"></input>
		</view>
		
		<view class="btn">
			<button @tap="update()" class="cu-btn lg" :style='{"padding":"0 30rpx","boxShadow":"0 0 16rpx rgba(0,0,0,0) inset","margin":"0 auto","backgroundColor":"rgba(123, 226, 205, 1)","borderColor":"#409EFF","borderRadius":"88rpx","color":"#fff","borderWidth":"0","width":"60%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'>保存</button>
			<button @tap="logout()" class="cu-btn lg" :style='{"padding":"0 30rpx","boxShadow":"0 0 16rpx rgba(0,0,0,0) inset","margin":"0 auto","backgroundColor":"rgba(213, 213, 213, 1)","borderColor":"#E6A23C","borderRadius":"88rpx","color":"#fff","borderWidth":"0","width":"60%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'>退出登录</button>
		</view>
	</view>
</view>
</template>

<script>
	export default {
		data() {
			return {
				ruleForm: {
				},
				tableName:"",
				xueshengxingbieOptions: [],
				xueshengxingbieIndex: 0,
				xueshengjiaoshigonghaoOptions: [],
				xueshengjiaoshigonghaoIndex: 0,
				jiaoshixingbieOptions: [],
				jiaoshixingbieIndex: 0,
				jiaoshizhichengOptions: [],
				jiaoshizhichengIndex: 0,
				shezhangxingbieOptions: [],
				shezhangxingbieIndex: 0,
			}
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
		async onLoad() {
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.ruleForm = res.data;
			this.tableName = table;
			// 自定义下拉框值
			if(this.tableName=='xuesheng'){
				this.xueshengxingbieOptions = "男,女".split(',');
				this.xueshengxingbieOptions.forEach((item, index) => {
					if(item==this.ruleForm.xingbie) {
						this.xueshengxingbieIndex = index;
					}
				});
			}
			// 下拉框
			if(this.tableName=='xuesheng'){
				res = await this.$api.option(`jiaoshi`,`jiaoshigonghao`,{});
				this.xueshengjiaoshigonghaoOptions = res.data;
				this.xueshengjiaoshigonghaoOptions.forEach((item, index) => {
					if(item==this.ruleForm.jiaoshigonghao) {
						this.xueshengjiaoshigonghaoIndex = index;
					}
				});
			}
			// 自定义下拉框值
			if(this.tableName=='jiaoshi'){
				this.jiaoshixingbieOptions = "男,女".split(',');
				this.jiaoshixingbieOptions.forEach((item, index) => {
					if(item==this.ruleForm.xingbie) {
						this.jiaoshixingbieIndex = index;
					}
				});
			}
			// 自定义下拉框值
			if(this.tableName=='jiaoshi'){
				this.jiaoshizhichengOptions = "助教,讲师,副教授,教授".split(',');
				this.jiaoshizhichengOptions.forEach((item, index) => {
					if(item==this.ruleForm.zhicheng) {
						this.jiaoshizhichengIndex = index;
					}
				});
			}
			// 自定义下拉框值
			if(this.tableName=='shezhang'){
				this.shezhangxingbieOptions = "男,女".split(',');
				this.shezhangxingbieOptions.forEach((item, index) => {
					if(item==this.ruleForm.xingbie) {
						this.shezhangxingbieIndex = index;
					}
				});
			}
			this.styleChange()
		},
		methods: {
                        // 下拉变化
                        xueshengxingbieChange(e) {
                                this.xueshengxingbieIndex = e.target.value
                                this.ruleForm.xingbie = this.xueshengxingbieOptions[this.xueshengxingbieIndex]
                        },
                        // 下拉变化
                        xueshengjiaoshigonghaoChange(e) {
                                this.xueshengjiaoshigonghaoIndex = e.target.value
                                this.ruleForm.jiaoshigonghao = this.xueshengjiaoshigonghaoOptions[this.xueshengjiaoshigonghaoIndex]
                        },
                        // 下拉变化
                        jiaoshixingbieChange(e) {
                                this.jiaoshixingbieIndex = e.target.value
                                this.ruleForm.xingbie = this.jiaoshixingbieOptions[this.jiaoshixingbieIndex]
                        },
                        // 下拉变化
                        jiaoshizhichengChange(e) {
                                this.jiaoshizhichengIndex = e.target.value
                                this.ruleForm.zhicheng = this.jiaoshizhichengOptions[this.jiaoshizhichengIndex]
                        },
                        // 下拉变化
                        shezhangxingbieChange(e) {
                                this.shezhangxingbieIndex = e.target.value
                                this.ruleForm.xingbie = this.shezhangxingbieOptions[this.shezhangxingbieIndex]
                        },
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.cu-form-group .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.userInfoForm.list.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			logout() {
				uni.setStorageSync('token', '');
				this.$utils.jump('../login/login');
			},
			// 注册
			async update() {
				if((!this.ruleForm.xuehao) && `xuesheng` == this.tableName){
					this.$utils.msg(`学号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `xuesheng` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
				if(`xuesheng` == this.tableName && this.ruleForm.lianxifangshi&&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
					this.$utils.msg(`联系方式应输入手机格式`);
					return
				}
				if(`xuesheng` == this.tableName && this.ruleForm.money&&(!this.$validate.isNumber(this.ruleForm.money))){
					this.$utils.msg(`余额应输入数字`);
					return
				}
				if((!this.ruleForm.jiaoshigonghao) && `jiaoshi` == this.tableName){
					this.$utils.msg(`教师工号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `jiaoshi` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
				if(`jiaoshi` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
					this.$utils.msg(`联系电话应输入手机格式`);
					return
				}
				if(`jiaoshi` == this.tableName && this.ruleForm.money&&(!this.$validate.isNumber(this.ruleForm.money))){
					this.$utils.msg(`余额应输入数字`);
					return
				}
				if((!this.ruleForm.shezhangzhanghao) && `shezhang` == this.tableName){
					this.$utils.msg(`社长账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `shezhang` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
				if(`shezhang` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
					this.$utils.msg(`联系电话应输入手机格式`);
					return
				}
				if(`shezhang` == this.tableName && this.ruleForm.money&&(!this.$validate.isNumber(this.ruleForm.money))){
					this.$utils.msg(`余额应输入数字`);
					return
				}
				let table = uni.getStorageSync("nowTable");
				await this.$api.update(table, this.ruleForm);
				this.$utils.msgBack('修改成功');;
			}

			,xueshengzhaopianTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.zhaopian = 'upload/' + res.file;
					_this.$forceUpdate();
				});
			}
			,jiaoshizhaopianTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.zhaopian = 'upload/' + res.file;
					_this.$forceUpdate();
				});
			}
			,shezhangtouxiangTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
				});
			}
		}
	}
</script>

<style lang="scss" scoped>
	page {
		background-color: #fff;
	}
	
	.content:after {
		position: fixed;
		top: 0;
		right: 0;
		left: 0;
		bottom: 0;
		content: '';
				background-image: url(http://codegen.caihongy.cn/20220215/ffc1c07eb6ce45c095f7aee03595b508.png);
				background-attachment: fixed;
		background-size: cover;
		background-position: center;
	}

	.avator {
		width: 110upx;
		height: 110upx;
		border-radius: 50%;
		margin-left: 30upx;
	}
	
	.cu-form-group.active {
		justify-content: space-between;
	}

	.cu-btn {
		width: 100%;
	}
	.cu-form-group .title {
		height: auto;
	}

	.right-input {
		flex: 1;
		text-align: left;
		line-height: 52rpx;
	}
	.btn {
	  display: flex;
	  align-items: center;
	  justify-content: center;
	  flex-wrap: wrap;
	}
	.box {
	  width: auto;
	  padding: 0 10upx;
	  box-sizing: border-box;
	  margin-bottom: 20upx;
	}

.picker-select-input {
	line-height: 52rpx;
}
</style>
