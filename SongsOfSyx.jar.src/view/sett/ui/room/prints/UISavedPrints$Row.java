/*     */ package view.sett.ui.room.prints;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.data.GETTER;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Row
/*     */   extends CLICKABLE.ClickWrap
/*     */ {
/*     */   private final UISavedPrints.RCat cat;
/*     */   private final UISavedPrints.RPrint print;
/*     */   private final CLICKABLE dum;
/*     */   private final GETTER<Integer> ier;
/*     */   
/*     */   Row(GETTER<Integer> ier) {
/* 153 */     super(200, 38); this.cat = new UISavedPrints.RCat(paramUISavedPrints); this.print = new UISavedPrints.RPrint(paramUISavedPrints); this.dum = (CLICKABLE)new CLICKABLE.ClickableAbs(380, 40) { protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {} };
/* 154 */     this.ier = ier;
/*     */   }
/*     */ 
/*     */   
/*     */   protected RENDEROBJ pget() {
/* 159 */     Entry e = (Entry)UISavedPrints.this.list.get().get(((Integer)this.ier.get()).intValue());
/* 160 */     if (e == null)
/* 161 */       return (RENDEROBJ)this.dum; 
/* 162 */     if (e.print != null) {
/* 163 */       this.print.e = e;
/* 164 */       return (RENDEROBJ)this.print;
/*     */     } 
/*     */     
/* 167 */     this.cat.e = e;
/* 168 */     return (RENDEROBJ)this.cat;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\prints\UISavedPrints$Row.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */