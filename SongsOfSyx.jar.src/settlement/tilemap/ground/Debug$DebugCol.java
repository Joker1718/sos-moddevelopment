/*     */ package settlement.tilemap.ground;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.gui.misc.GColorPicker;
/*     */ import view.interrupter.ISidePanel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class DebugCol
/*     */   extends ISidePanel
/*     */ {
/* 126 */   private final ColorImp dry = new ColorImp(COLOR.WHITE50);
/* 127 */   private final ColorImp wet = new ColorImp(COLOR.WHITE50);
/*     */   
/*     */   DebugCol() {
/* 130 */     titleSet("ground color");
/* 131 */     this.dry.set((COLOR)(SETT.GROUND()).dry);
/* 132 */     this.wet.set((COLOR)(SETT.GROUND()).wet);
/* 133 */     this.section.addDown(2, (RENDEROBJ)new GColorPicker(false, "dry")
/*     */         {
/*     */           public ColorImp color()
/*     */           {
/* 137 */             return Debug.DebugCol.this.dry;
/*     */           }
/*     */ 
/*     */           
/*     */           public void change() {
/* 142 */             SETT.GROUND().setColors((COLOR)Debug.DebugCol.this.dry, (COLOR)Debug.DebugCol.this.wet, 0.0D);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 147 */     this.section.addDown(2, (RENDEROBJ)new GColorPicker(false, "wet")
/*     */         {
/*     */           public ColorImp color()
/*     */           {
/* 151 */             return Debug.DebugCol.this.wet;
/*     */           }
/*     */ 
/*     */           
/*     */           public void change() {
/* 156 */             SETT.GROUND().setColors((COLOR)Debug.DebugCol.this.dry, (COLOR)Debug.DebugCol.this.wet, 0.0D);
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\ground\Debug$DebugCol.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */