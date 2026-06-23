/*     */ package menu;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 186 */     super($anonymous0, $anonymous1);
/* 187 */     this.t = (UI.FONT()).M.getText(17);
/*     */     
/* 189 */     this.t.setMaxWidth(400);
/* 190 */     this.t.setMultipleLines(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 196 */     if (ScCampaign.this.current == null) {
/*     */       return;
/*     */     }
/* 199 */     COLOR col = COLOR.GREEN100;
/* 200 */     if (ScCampaign.this.current.locked()) {
/* 201 */       col = COLOR.REDISH;
/* 202 */     } else if (!ScCampaign.this.completed.contains(ScCampaign.this.current.key)) {
/* 203 */       col = COLOR.BLUEISH;
/* 204 */     }  col.bind();
/*     */     
/* 206 */     this.t.clear();
/* 207 */     if (ScCampaign.this.current.requires.length > 0) {
/* 208 */       this.t.add(Dic.¤¤Requires).add(':');
/* 209 */       this.t.s(); byte b; int i; String[] arrayOfString;
/* 210 */       for (i = (arrayOfString = ScCampaign.this.current.requires).length, b = 0; b < i; ) { String s = arrayOfString[b];
/* 211 */         if (cmap.containsKey(s)) {
/* 212 */           this.t.add(((ScCampaign.Campaign)cmap.get(s)).info.name);
/*     */         } else {
/* 214 */           this.t.add('?').s().add(s);
/*     */         } 
/*     */         b++; }
/*     */     
/*     */     } 
/* 219 */     this.t.renderCY(r, X1, Y1 + (Y2 - Y1) / 2);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\ScCampaign$7.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */