/*     */ package view.ui.advice;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.employment.RoomEmployment;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends UIAdvice.Entry
/*     */ {
/*     */   double ee;
/*     */   double tot;
/*     */   private final UIAdvice.Count<RoomEmployment> count;
/*     */   
/*     */   null(ArrayListGrower<UIAdvice.Entry> $anonymous0, SPRITE $anonymous1, CharSequence $anonymous2, CharSequence $anonymous3, CharSequence $anonymous4) {
/* 280 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4);
/*     */     
/* 282 */     this.ee = 0.0D;
/* 283 */     this.tot = 0.0D;
/* 284 */     this.count = new UIAdvice.Count<RoomEmployment>((SETT.ROOMS()).employment.ALL())
/*     */       {
/*     */         void count(RoomEmployment t)
/*     */         {
/* 288 */           UIAdvice.null.this.ee += t.employed() * t.efficiency();
/* 289 */           UIAdvice.null.this.tot += t.employed();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         boolean pis() {
/* 296 */           if (UIAdvice.null.this.ee > 20.0D) {
/* 297 */             if (UIAdvice.null.this.ee / UIAdvice.null.this.tot < 0.85D) {
/* 298 */               UIAdvice.null.this.old = 0.0D;
/* 299 */               return true;
/*     */             } 
/* 301 */             if (UIAdvice.null.this.old < 0.85D) {
/* 302 */               return true;
/*     */             }
/* 304 */             UIAdvice.null.this.old = 1.0D;
/*     */           } 
/*     */           
/* 307 */           UIAdvice.null.this.old = 1.0D;
/* 308 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         void clear() {
/* 313 */           UIAdvice.null.this.ee = 0.0D;
/* 314 */           UIAdvice.null.this.tot = 0.0D;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   boolean is() {
/* 321 */     return this.count.is();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\advice\UIAdvice$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */