/*     */ package game.faction;
/*     */ 
/*     */ import init.type.HCLASSES;
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
/*     */ public enum CTYPE
/*     */ {
/* 134 */   TRADE(FCredits.¤¤TRADE, FCredits.¤¤TRADED),
/* 135 */   INFLATION(FCredits.¤¤INFLATION, FCredits.¤¤INFLATIOND),
/* 136 */   MISC(FCredits.¤¤MISC, FCredits.¤¤MISCD),
/* 137 */   TRIBUTE(FCredits.¤¤TRIBUTE, FCredits.¤¤TRIBUTED),
/*     */   
/* 139 */   DIPLOMACY(Dic.¤¤Diplomacy, FCredits.¤¤DIPLOMACYD),
/* 140 */   MERCINARIES(FCredits.¤¤MERCINARIES, FCredits.¤¤MERCINARIESD),
/* 141 */   TOURISM(FCredits.¤¤TOURISM, FCredits.¤¤TOURISMD),
/* 142 */   CONSTRUCTION(FCredits.¤¤CONSTRUCTION, FCredits.¤¤CONSTRUCTIOND),
/* 143 */   TAX(FCredits.¤¤TAX, FCredits.¤¤TAXD),
/* 144 */   SLAVES((HCLASSES.SLAVE()).name, FCredits.¤¤SLAVESD);
/*     */   
/*     */   public final CharSequence name;
/*     */   
/*     */   public final CharSequence desc;
/*     */   
/*     */   CTYPE(CharSequence name, CharSequence desc) {
/* 151 */     this.name = name;
/* 152 */     this.desc = desc;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\FCredits$CTYPE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */