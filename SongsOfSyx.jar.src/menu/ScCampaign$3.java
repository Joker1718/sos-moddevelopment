/*     */ package menu;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends SPRITE.Imp
/*     */ {
/*     */   Text t;
/*     */   
/*     */   null(int $anonymous0, int $anonymous1) {
/* 103 */     super($anonymous0, $anonymous1);
/* 104 */     this.t = (UI.FONT()).H2.getText(17);
/*     */     
/* 106 */     this.t.setMaxWidth(368);
/* 107 */     this.t.setMultipleLines(true);
/* 108 */     this.t.add(paramCampaign.info.name);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 113 */     this.t.renderCY(r, X1 + 32, Y1 + (Y2 - Y1) / 2);
/*     */     
/* 115 */     COLOR col = COLOR.GREEN100;
/* 116 */     if (c.locked()) {
/* 117 */       col = COLOR.WHITE50;
/* 118 */     } else if (!ScCampaign.this.completed.contains(c.key)) {
/* 119 */       col = COLOR.BLUEISH;
/* 120 */     }  col.bind();
/* 121 */     (UI.icons()).s.dot.big.renderCY(r, X1, Y1 + (Y2 - Y1) / 2);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\ScCampaign$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */