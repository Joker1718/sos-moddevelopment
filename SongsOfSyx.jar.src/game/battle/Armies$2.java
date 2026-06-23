/*     */ package game.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import init.constant.Config;
/*     */ import settlement.entity.EntityIterator;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements ACTION
/*     */ {
/*     */   public void exe() {
/*  79 */     final Bitmap2D check = new Bitmap2D((Config.battle()).MEN_PER_DIVISION, (Config.battle()).DIVISIONS_PER_BATTLE, false);
/*     */     
/*  81 */     (new EntityIterator.Humans()
/*     */       {
/*     */         protected boolean processAndShouldBreakH(Humanoid h, int ie)
/*     */         {
/*  85 */           if (h.division() != null) {
/*  86 */             check.set((h.division()).reporter.positionSpot(h), h.division().index(), true);
/*     */           }
/*  88 */           return false;
/*     */         }
/*  90 */       }).iterate();
/*     */ 
/*     */ 
/*     */     
/*  94 */     for (Div d : Armies.this.divisions) {
/*     */       int i;
/*  96 */       for (i = 0; i < d.menNrOf(); i++) {
/*  97 */         if (!check.is(i, d.index())) {
/*  98 */           LOG.ln("errors in division " + d.index());
/*     */ 
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */       
/* 105 */       if (d.menNrOf() > 0) {
/*     */         
/* 107 */         GAME.Notify(Short.valueOf(d.index()));
/*     */         
/* 109 */         for (i = 0; i < d.menNrOf(); i++) {
/* 110 */           check.set(i, d.index(), false);
/*     */         }
/*     */         
/* 113 */         (new EntityIterator.Humans()
/*     */           {
/*     */             
/*     */             protected boolean processAndShouldBreakH(Humanoid h, int ie)
/*     */             {
/* 118 */               for (int i = 0; i < d.menNrOf(); i++) {
/* 119 */                 check.set(i, d.index(), false);
/*     */               }
/*     */               
/* 122 */               if (h.division() == d) {
/* 123 */                 if (h.divSpot() != d.reporter.positionSpot(h)) {
/* 124 */                   LOG.ln("" + h.divSpot() + " -> " + h.divSpot());
/*     */                 }
/*     */ 
/*     */                 
/* 128 */                 check.set((h.division()).reporter.positionSpot(h), h.division().index(), true);
/*     */               } 
/*     */ 
/*     */ 
/*     */               
/* 133 */               return false;
/*     */             }
/* 135 */           }).iterate();
/* 136 */         LOG.ln();
/* 137 */         for (i = 0; i < d.menNrOf(); i++) {
/* 138 */           int pi = d.reporter.positionSpot(i);
/* 139 */           if (i != pi)
/* 140 */             LOG.ln("" + i + " -> " + i); 
/*     */         } 
/*     */       } 
/*     */     } 
/* 144 */     GAME.Notify("test completed");
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\Armies$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */