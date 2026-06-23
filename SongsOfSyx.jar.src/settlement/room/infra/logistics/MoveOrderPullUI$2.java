/*     */ package settlement.room.infra.logistics;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
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
/* 142 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 146 */     GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 147 */     if (((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()[oi] == null) {
/* 148 */       (UI.icons()).m.storage_pull.renderC(r, this.body.cX(), this.body.cY());
/* 149 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */       
/*     */       return;
/*     */     } 
/* 153 */     MoveOrderPull o = ((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()[oi];
/*     */     
/* 155 */     if (o.problem((MoveOrderPull.MoveOrderPullInstance)source.get()) != null) {
/* 156 */       (GCOLOR.UI()).BAD.hovered.bind();
/* 157 */     } else if (o.warning((MoveOrderPull.MoveOrderPullInstance)source.get()) != null) {
/* 158 */       (GCOLOR.UI()).SOSO.hovered.bind();
/*     */     } else {
/* 160 */       (GCOLOR.UI()).GOOD.hovered.bind();
/*     */     } 
/* 162 */     (UI.icons()).s.alert.renderC(r, body().cX(), this.body.cY());
/* 163 */     COLOR.unbind();
/* 164 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */     
/* 166 */     if (isHovered && ((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()[oi].source() != null) {
/* 167 */       RoomInstance ins = (RoomInstance)((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()[oi].source();
/* 168 */       SETT.OVERLAY().add(ins.mX(), ins.mY());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 174 */     if (((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()[oi] == null) {
/* 175 */       placer.activate(oi);
/*     */     } else {
/* 177 */       (VIEW.inters()).popup.show((RENDEROBJ)popup.get(oi), (CLICKABLE)this);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 183 */     GBox b = (GBox)text;
/* 184 */     b.title(MoveOrderPullUI.¤¤name);
/* 185 */     MoveOrderPull o = ((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()[oi];
/* 186 */     if (o == null) {
/* 187 */       b.text(MoveOrderPullUI.¤¤issue);
/*     */       return;
/*     */     } 
/* 190 */     b.textLL(MoveOrderPullUI.¤¤name);
/* 191 */     b.tab(6);
/* 192 */     if (o.sourceI() == null) {
/* 193 */       b.error(MoveOrderPullUI.¤¤notSet);
/*     */     } else {
/* 195 */       b.text((CharSequence)o.sourceI().name());
/*     */     } 
/* 197 */     b.NL();
/*     */     
/* 199 */     if (o.problem((MoveOrderPull.MoveOrderPullInstance)source.get()) != null) {
/* 200 */       b.error(o.problem((MoveOrderPull.MoveOrderPullInstance)source.get()));
/* 201 */     } else if (o.warning((MoveOrderPull.MoveOrderPullInstance)source.get()) != null) {
/* 202 */       b.add((SPRITE)b.text().warnify().add(o.warning((MoveOrderPull.MoveOrderPullInstance)source.get())));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveOrderPullUI$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */