/*     */ package view.world.ui.battle;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.data.DOUBLE;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GRows;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Spoils
/*     */   extends GuiSection
/*     */ {
/* 207 */   private int[] accepted = Alloc.ii(RESOURCES.ALL().size());
/*     */   
/*     */   private final int[] available;
/*     */   private final DOUBLE mul;
/*     */   
/*     */   Spoils(final int[] resources, final DOUBLE mul) {
/* 213 */     this.available = resources;
/* 214 */     this.mul = mul;
/* 215 */     int am = 4;
/* 216 */     GRows rows = new GRows(am);
/* 217 */     final GText t = new GText((UI.FONT()).S, 16);
/* 218 */     for (RESOURCE res : RESOURCES.ALL()) {
/* 219 */       if (resources[res.index()] != 0)
/*     */       {
/* 221 */         rows.add((RENDEROBJ)new HOVERABLE.HoverableAbs(600 / am - 12, 28)
/*     */             {
/*     */               protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */               {
/* 225 */                 (res.icon()).medium.renderCY(r, body().x1() + 8, body().cY());
/* 226 */                 t.clear();
/* 227 */                 GFORMAT.iIncr(t, (long)(resources[res.index()] * mul.getD()));
/* 228 */                 t.renderCY(r, body().x1() + 40, body().cY());
/*     */               }
/*     */ 
/*     */               
/*     */               public void hoverInfoGet(GUI_BOX text) {
/* 233 */                 text.title(res.names);
/*     */               }
/*     */             });
/*     */       }
/*     */     } 
/*     */     
/* 239 */     add((RENDEROBJ)(new GScrollRows((Iterable)rows.rows(), 112)).view());
/*     */   }
/*     */   
/*     */   public int[] accepted() {
/* 243 */     for (int i = 0; i < this.accepted.length; i++) {
/* 244 */       this.accepted[i] = CLAMP.i((int)(this.available[i] * this.mul.getD()), 0, this.available[i]);
/*     */     }
/* 246 */     return this.accepted;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\Res$Spoils.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */