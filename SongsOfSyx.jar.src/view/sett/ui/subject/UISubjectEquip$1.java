/*    */ package view.sett.ui.subject;
/*    */ 
/*    */ import init.settings.S;
/*    */ import init.sprite.UI.UI;
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.equip.Equip;
/*    */ import settlement.stats.stat.STAT;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import util.data.DOUBLE_O;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends CLICKABLE.ClickableAbs
/*    */ {
/*    */   private final GText t;
/*    */   
/*    */   null(int $anonymous0, int $anonymous1) {
/* 50 */     super($anonymous0, $anonymous1);
/* 51 */     this.t = new GText((UI.FONT()).S, 8);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 56 */     if (isHovered) {
/* 57 */       COLOR.BLUEDARK.render(r, (RECTANGLE)body());
/*    */     }
/*    */     
/* 60 */     pp.resource().icon().renderC(r, body().cX(), body().y1() + 16);
/* 61 */     this.t.clear();
/* 62 */     int am = p.indu().get(a.a.indu());
/* 63 */     int max = pp.max(a.a.indu());
/* 64 */     GFORMAT.iofk(this.t, am, max);
/* 65 */     this.t.lablify();
/* 66 */     this.t.adjustWidth();
/* 67 */     this.t.renderC(r, body().cX(), body().y1() + 32);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 73 */     pp.hover(text, a.a.indu());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 78 */     if ((S.get()).developer) {
/* 79 */       DebugInput.activate((DOUBLE_O.DOUBLE_OE<Induvidual>)p.indu(), a.a);
/*    */     } else {
/* 81 */       (VIEW.s()).ui.standing.openAccess(a.a.race());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectEquip$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */