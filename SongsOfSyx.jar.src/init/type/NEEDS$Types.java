/*     */ package init.type;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.sets.LISTE;
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
/*     */ public final class Types
/*     */ {
/*     */   public final NEED_E HUNGER;
/*     */   public final NEED_E THIRST;
/*     */   public final NEED_E SHOPPING;
/*     */   public final NEED SKINNYDIP;
/*     */   public final NEED TEMPLE;
/*     */   public final NEED SHRINE;
/*     */   
/*     */   public Types() {
/* 126 */     this.HUNGER = new NEED_E("_HUNGER", paramNEEDS.f, (LISTE<NEED>)paramNEEDS.ALL, (LISTE<NEED_E>)paramNEEDS.ALLE, paramNEEDS.bCatE);
/* 127 */     this.THIRST = new NEED_E("_THIRST", paramNEEDS.f, (LISTE<NEED>)paramNEEDS.ALL, (LISTE<NEED_E>)paramNEEDS.ALLE, paramNEEDS.bCatE);
/* 128 */     this.SHOPPING = new NEED_E("_SHOPPING", paramNEEDS.f, (LISTE<NEED>)paramNEEDS.ALL, (LISTE<NEED_E>)paramNEEDS.ALLE, paramNEEDS.bCatE);
/* 129 */     this.SKINNYDIP = new NEED("_SKINNYDIP", paramNEEDS.f, (LISTE<NEED>)paramNEEDS.ALL, paramNEEDS.bCat, (SPRITE)(UI.icons()).s.drop, false);
/* 130 */     this.TEMPLE = new NEED("_TEMPLE", paramNEEDS.f, (LISTE<NEED>)paramNEEDS.ALL, paramNEEDS.bCat, (SPRITE)(UI.icons()).s.temple, false);
/* 131 */     this.SHRINE = new NEED("_SHRINE", paramNEEDS.f, (LISTE<NEED>)paramNEEDS.ALL, paramNEEDS.bCat, (SPRITE)(UI.icons()).s.shrine, false);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\NEEDS$Types.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */