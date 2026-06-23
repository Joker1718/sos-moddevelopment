/*     */ package view.world.ui.battle;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupplies;
/*     */ import world.battle.spec.WBattleSide;
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
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   null(int $anonymous0, int $anonymous1) {
/* 192 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 196 */     int am = 0;
/* 197 */     for (int i = 0; i < AD.supplies().arts().size(); i++) {
/* 198 */       am += ((WBattleSide)g.get()).artillery((ADSupplies.ADArtillery)AD.supplies().arts().get(i));
/*     */     }
/*     */     
/* 201 */     if (am <= 0) {
/*     */       return;
/*     */     }
/* 204 */     int d = (body().width() - 50) / am;
/* 205 */     d = CLAMP.i(d, 1, 16);
/*     */     
/* 207 */     int j = 0;
/* 208 */     for (ADSupplies.ADArtillery a : AD.supplies().arts()) {
/* 209 */       for (int k = 0; k < ((WBattleSide)g.get()).artillery(a); k++) {
/* 210 */         a.art.icon.small.render(r, this.body.x1() + j * d, body().y1());
/* 211 */         j++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 219 */     GBox b = (GBox)text;
/* 220 */     for (int i = 0; i < AD.supplies().arts().size(); i++) {
/* 221 */       ADSupplies.ADArtillery a = (ADSupplies.ADArtillery)AD.supplies().arts().get(i);
/* 222 */       int am = ((WBattleSide)g.get()).artillery(a);
/* 223 */       if (am > 0) {
/* 224 */         b.add(((ADSupplies.ADArtillery)AD.supplies().arts().get(i)).art.icon.small);
/* 225 */         b.text(a.art.info.names);
/* 226 */         b.tab(7);
/* 227 */         b.add((SPRITE)GFORMAT.i(b.text(), am));
/* 228 */         b.NL();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\Battle$7.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */