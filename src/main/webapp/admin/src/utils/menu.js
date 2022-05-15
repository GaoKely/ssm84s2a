const menu = {
    list() {
        return [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["新增","查看","修改","删除"],"menu":"学生","menuJump":"列表","tableName":"xuesheng"}],"menu":"学生管理"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["新增","查看","修改","删除"],"menu":"教师","menuJump":"列表","tableName":"jiaoshi"}],"menu":"教师管理"},{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["新增","查看","修改","删除","审核"],"menu":"社长","menuJump":"列表","tableName":"shezhang"}],"menu":"社长管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["新增","查看","修改","删除"],"menu":"商品分类","menuJump":"列表","tableName":"shangpinfenlei"}],"menu":"商品分类管理"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["新增","查看","修改","删除","查看评论"],"menu":"热卖商品","menuJump":"列表","tableName":"remaishangpin"}],"menu":"热卖商品管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["新增","查看","修改","删除"],"menu":"社团活动","menuJump":"列表","tableName":"shetuanhuodong"}],"menu":"社团活动管理"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看","删除","审核","报表"],"menu":"活动申请","menuJump":"列表","tableName":"huodongshenqing"}],"menu":"活动申请管理"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["查看","修改","删除","查看评论"],"menu":"表白墙","menuJump":"列表","tableName":"biaobaiqiang"}],"menu":"表白墙管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","修改","删除"],"menu":"考试成绩","menuJump":"列表","tableName":"kaoshichengji"}],"menu":"考试成绩管理"},{"child":[{"appFrontIcon":"cuIcon-message","buttons":["查看","修改","回复","删除"],"menu":"投诉建议","tableName":"messages"}],"menu":"投诉建议"},{"child":[{"appFrontIcon":"cuIcon-group","buttons":["新增","查看","修改","删除"],"menu":"交流论坛","tableName":"forum"}],"menu":"交流论坛"},{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"校园公告","tableName":"news"}],"menu":"系统管理"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["查看","删除"],"menu":"未支付订单","tableName":"orders/未支付"},{"appFrontIcon":"cuIcon-keyboard","buttons":["删除","查看"],"menu":"已取消订单","tableName":"orders/已取消"},{"appFrontIcon":"cuIcon-link","buttons":["删除","查看","发货"],"menu":"已支付订单","tableName":"orders/已支付"},{"appFrontIcon":"cuIcon-skin","buttons":["查看","删除"],"menu":"已退款订单","tableName":"orders/已退款"},{"appFrontIcon":"cuIcon-album","buttons":["查看","删除"],"menu":"已完成订单","tableName":"orders/已完成"},{"appFrontIcon":"cuIcon-full","buttons":["删除","查看"],"menu":"已发货订单","tableName":"orders/已发货"}],"menu":"订单管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["查看","查看评论"],"menu":"热卖商品列表","menuJump":"列表","tableName":"remaishangpin"}],"menu":"热卖商品模块"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看","申请加入"],"menu":"社团活动列表","menuJump":"列表","tableName":"shetuanhuodong"}],"menu":"社团活动模块"},{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["查看","查看评论"],"menu":"表白墙列表","menuJump":"列表","tableName":"biaobaiqiang"}],"menu":"表白墙模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["申请加入","查看"],"menu":"社团活动","menuJump":"列表","tableName":"shetuanhuodong"}],"menu":"社团活动管理"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["删除","查看"],"menu":"活动申请","menuJump":"列表","tableName":"huodongshenqing"}],"menu":"活动申请管理"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["新增","查看","修改","删除"],"menu":"表白墙","menuJump":"列表","tableName":"biaobaiqiang"}],"menu":"表白墙管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","删除"],"menu":"考试成绩","menuJump":"列表","tableName":"kaoshichengji"}],"menu":"考试成绩管理"},{"child":[{"appFrontIcon":"cuIcon-favor","buttons":["新增","查看","修改","删除"],"menu":"我的收藏管理","tableName":"storeup"}],"menu":"我的收藏管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["查看","查看评论"],"menu":"热卖商品列表","menuJump":"列表","tableName":"remaishangpin"}],"menu":"热卖商品模块"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看","申请加入"],"menu":"社团活动列表","menuJump":"列表","tableName":"shetuanhuodong"}],"menu":"社团活动模块"},{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["查看","查看评论"],"menu":"表白墙列表","menuJump":"列表","tableName":"biaobaiqiang"}],"menu":"表白墙模块"}],"hasBackLogin":"否","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"学生","tableName":"xuesheng"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","成绩"],"menu":"学生","menuJump":"列表","tableName":"xuesheng"}],"menu":"学生管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","删除"],"menu":"考试成绩","menuJump":"列表","tableName":"kaoshichengji"}],"menu":"考试成绩管理"},{"child":[{"appFrontIcon":"cuIcon-favor","buttons":["查看","修改","删除"],"menu":"我的收藏管理","tableName":"storeup"}],"menu":"我的收藏管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["查看","查看评论"],"menu":"热卖商品列表","menuJump":"列表","tableName":"remaishangpin"}],"menu":"热卖商品模块"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看","申请加入"],"menu":"社团活动列表","menuJump":"列表","tableName":"shetuanhuodong"}],"menu":"社团活动模块"},{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["查看","查看评论"],"menu":"表白墙列表","menuJump":"列表","tableName":"biaobaiqiang"}],"menu":"表白墙模块"}],"hasBackLogin":"否","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"教师","tableName":"jiaoshi"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["新增","查看","修改","删除"],"menu":"社团活动","menuJump":"列表","tableName":"shetuanhuodong"}],"menu":"社团活动管理"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看","删除","审核","报表"],"menu":"活动申请","menuJump":"列表","tableName":"huodongshenqing"}],"menu":"活动申请管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["查看","查看评论"],"menu":"热卖商品列表","menuJump":"列表","tableName":"remaishangpin"}],"menu":"热卖商品模块"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看","申请加入"],"menu":"社团活动列表","menuJump":"列表","tableName":"shetuanhuodong"}],"menu":"社团活动模块"},{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["查看","查看评论"],"menu":"表白墙列表","menuJump":"列表","tableName":"biaobaiqiang"}],"menu":"表白墙模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"社长","tableName":"shezhang"}]
    }
}
export default menu;