/*     */ package view.ui.wiki;
/*     */ 
/*     */ import snake2d.util.sets.Tree;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends Tree<Article>
/*     */ {
/*     */   null(int $anonymous0) {
/* 104 */     super($anonymous0);
/*     */   }
/*     */   protected boolean isGreaterThan(Article ce, Article c2) {
/* 107 */     return smaller(ce.key, c2.key);
/*     */   }
/*     */   
/*     */   boolean smaller(CharSequence current, CharSequence cmp) {
/* 111 */     for (int i = 0; i < current.length(); i++) {
/* 112 */       if (i >= cmp.length())
/* 113 */         return false; 
/* 114 */       if (current.charAt(i) > cmp.charAt(i))
/* 115 */         return false; 
/* 116 */       if (current.charAt(i) < cmp.charAt(i))
/* 117 */         return true; 
/*     */     } 
/* 119 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\wiki\WIKI$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */