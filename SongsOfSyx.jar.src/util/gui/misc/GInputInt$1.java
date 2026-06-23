/*    */ package util.gui.misc;
/*    */ 
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.sprite.text.Font;
/*    */ import snake2d.util.sprite.text.StringInputSprite;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends StringInputSprite
/*    */ {
/*    */   null(int $anonymous0, Font $anonymous1) {
/* 17 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void change() {
/* 21 */     int num = 0;
/* 22 */     int sign = 1;
/* 23 */     for (int i = 0; i < text().length(); i++) {
/* 24 */       if (i == 0 && text().charAt(i) == '-') {
/* 25 */         sign = -1;
/*    */       }
/*    */       else {
/*    */         
/* 29 */         int n = text().charAt(i) - 48;
/* 30 */         if (n >= 0 && n < 10) {
/* 31 */           if (num * 10 + n > GInputInt.this.in.max())
/*    */             break; 
/* 33 */           num *= 10;
/* 34 */           num += n;
/*    */         } else {
/* 36 */           GInputInt.this.unfuck(); return;
/*    */         } 
/*    */       } 
/*    */     } 
/* 40 */     if (num == 0 && sign == -1 && GInputInt.this.in.min() < 0) {
/* 41 */       GInputInt.this.in.set(0);
/* 42 */       text().clear().add('-');
/*    */     } else {
/* 44 */       GInputInt.this.in.set(CLAMP.i(num * sign, GInputInt.this.in.min(), GInputInt.this.in.max()));
/* 45 */       text().clear().add(GInputInt.this.in.get());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GInputInt$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */