/*    */ package view.world.ui.army;
/*    */ 
/*    */ import view.ui.div.UIDivBannerEditor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends UIDivBannerEditor
/*    */ {
/*    */   public void bannerISet(int bi) {
/* 68 */     super.bannerISet(bi);
/* 69 */     for (int i = 0; i < Army.this.selected.length; i++) {
/* 70 */       if (Army.this.selected[i] && 
/* 71 */         Army.army != null && Army.army.divs() != null && Army.army.divs().get(i) != null)
/*    */       {
/* 73 */         Army.army.divs().get(i).bannerSet(bi);
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\army\Army$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */