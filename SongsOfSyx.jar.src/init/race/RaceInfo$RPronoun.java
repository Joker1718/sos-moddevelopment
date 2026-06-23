/*     */ package init.race;
/*     */ 
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RPronoun
/*     */ {
/*     */   public final CharSequence[] pronouns;
/*     */   public final CharSequence[] pronounsC;
/*     */   
/*     */   RPronoun(String key, Json text) {
/* 123 */     this.pronouns = (CharSequence[])text.texts(key);
/* 124 */     this.pronounsC = (CharSequence[])text.texts(key + "C");
/*     */   }
/*     */   
/*     */   public CharSequence get(Induvidual i, boolean cap) {
/* 128 */     int k = (STATS.APPEARANCE()).gender.get(i);
/* 129 */     return get(k, cap);
/*     */   }
/*     */   
/*     */   public CharSequence get(int gender, boolean cap) {
/* 133 */     int k = gender;
/* 134 */     CharSequence[] ll = this.pronouns;
/* 135 */     if (cap)
/* 136 */       ll = this.pronounsC; 
/* 137 */     k = CLAMP.i(k, 0, ll.length - 1);
/* 138 */     return ll[k];
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\RaceInfo$RPronoun.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */