/*     */ package view.ui.economy;
/*     */ 
/*     */ import game.faction.player.PCredits;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class SDetail
/*     */   implements SPRITE
/*     */ {
/* 110 */   private final GStat stat = new GStat()
/*     */     {
/*     */       public void update(GText text)
/*     */       {
/* 114 */         MainDetails.SDetail.this.up(text);
/*     */       }
/*     */     };
/*     */   
/*     */   private final PCredits.CredHistory cr;
/*     */   
/*     */   SDetail(PCredits.CredHistory cr) {
/* 121 */     this.cr = cr;
/*     */   }
/*     */ 
/*     */   
/*     */   abstract void up(GText paramGText);
/*     */   
/*     */   public int width() {
/* 128 */     return 260;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int height() {
/* 135 */     return this.stat.height();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 142 */     ColorImp.TMP.set((COLOR)COLOR.UNIQUE.getC(this.cr.type.ordinal())).shadeSelf(0.5D);
/* 143 */     ColorImp.TMP.render(r, X1, X1 + height(), Y1, Y1 + height());
/* 144 */     ColorImp.TMP.set((COLOR)COLOR.UNIQUE.getC(this.cr.type.ordinal()));
/* 145 */     ColorImp.TMP.render(r, X1 + 2, X1 + height() - 2, Y1 + 2, Y1 + height() - 2);
/*     */     
/* 147 */     MainDetails.this.t.clear().add(this.cr.type.name);
/*     */     
/* 149 */     MainDetails.this.t.render(r, X1 + height() * 2, Y1);
/*     */     
/* 151 */     this.stat.adjust();
/*     */     
/* 153 */     this.stat.render(r, X2 - this.stat.width(), Y1);
/*     */   }
/*     */   
/*     */   public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\economy\MainDetails$SDetail.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */