/*     */ package settlement.room.infra.logistics;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   null(int $anonymous0, int $anonymous1) {
/*  65 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  69 */     GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/*  70 */     if (((MoveOrderPush.MoveOrderPushInstance)source.get()).moveOrdersPush()[oi] == null) {
/*  71 */       (UI.icons()).m.storage_push.renderC(r, this.body.cX(), this.body.cY());
/*  72 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */       
/*     */       return;
/*     */     } 
/*  76 */     MoveOrderPush o = ((MoveOrderPush.MoveOrderPushInstance)source.get()).moveOrdersPush()[oi];
/*     */     
/*  78 */     if (isHovered && o.destI() != null) {
/*  79 */       SETT.OVERLAY().add(o.destI().mX(), o.destI().mY());
/*     */     }
/*     */     
/*  82 */     if (o.problem((MoveOrderPush.MoveOrderPushInstance)source.get()) != null) {
/*  83 */       (GCOLOR.UI()).BAD.hovered.bind();
/*  84 */     } else if (o.warning((MoveOrderPush.MoveOrderPushInstance)source.get()) != null) {
/*  85 */       (GCOLOR.UI()).SOSO.hovered.bind();
/*     */     } else {
/*  87 */       (GCOLOR.UI()).GOOD.hovered.bind();
/*     */     } 
/*  89 */     (UI.icons()).s.alert.renderC(r, body().cX(), this.body.cY());
/*  90 */     COLOR.unbind();
/*  91 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/*  96 */     if (((MoveOrderPush.MoveOrderPushInstance)source.get()).moveOrdersPush()[oi] == null) {
/*  97 */       placer.activate(oi);
/*     */     } else {
/*  99 */       (VIEW.inters()).popup.show((RENDEROBJ)popup.get(oi), (CLICKABLE)this);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 105 */     GBox b = (GBox)text;
/* 106 */     b.title(MoveOrderPushUI.¤¤name);
/* 107 */     MoveOrderPush o = ((MoveOrderPush.MoveOrderPushInstance)source.get()).moveOrdersPush()[oi];
/* 108 */     if (o == null) {
/* 109 */       b.text(MoveOrderPushUI.¤¤issue);
/*     */       return;
/*     */     } 
/* 112 */     b.textLL(MoveOrderPushUI.¤¤name);
/* 113 */     b.tab(6);
/* 114 */     if (o.destI() == null) {
/* 115 */       b.error(MoveOrderPushUI.¤¤notSet);
/*     */     } else {
/* 117 */       b.text((CharSequence)o.destI().name());
/*     */     } 
/* 119 */     b.NL();
/*     */     
/* 121 */     if (o.problem((MoveOrderPush.MoveOrderPushInstance)source.get()) != null) {
/* 122 */       b.error(o.problem((MoveOrderPush.MoveOrderPushInstance)source.get()));
/* 123 */     } else if (o.warning((MoveOrderPush.MoveOrderPushInstance)source.get()) != null) {
/* 124 */       b.add((SPRITE)b.text().warnify().add(o.warning((MoveOrderPush.MoveOrderPushInstance)source.get())));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveOrderPushUI$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */