/*    */ package init.race.bio;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.stats.stat.STAT;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.text.Dic;
/*    */ 
/*    */ public final class Opinion
/*    */ {
/* 11 */   private static final CharSequence[] dm = new CharSequence[] { String.valueOf(Dic.¤¤More) + ": {0}" };
/* 12 */   private static final CharSequence[] dl = new CharSequence[] { String.valueOf(Dic.¤¤Less) + ": {0}" };
/*    */   
/* 14 */   CharSequence[] more = dm;
/* 15 */   CharSequence[] less = dl;
/*    */   
/* 17 */   public static final Opinion DEF = new Opinion();
/*    */ 
/*    */ 
/*    */   
/*    */   public Opinion() {}
/*    */ 
/*    */   
/*    */   Opinion(Json morg, Json mspe, Json lorg, Json lspe, String key) {
/* 25 */     this.more = get(morg, mspe, key, dm);
/* 26 */     this.less = get(lorg, lspe, key, dl);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private CharSequence[] get(Json org, Json spe, String key, CharSequence[] backup) {
/* 32 */     Json j = org;
/* 33 */     if (spe != null && spe.has(key)) {
/* 34 */       j = spe;
/*    */     }
/* 36 */     if (j != null && j.has(key)) {
/* 37 */       String[] arrayOfString = j.texts(key);
/* 38 */       if (arrayOfString.length > 0)
/* 39 */         return (CharSequence[])arrayOfString; 
/*    */     } 
/* 41 */     return backup;
/*    */   }
/*    */   
/*    */   public Opinion setMore(CharSequence... more) {
/* 45 */     if (more == null || more.length == 0) {
/* 46 */       this.more = dm;
/*    */     } else {
/* 48 */       this.more = more;
/* 49 */     }  return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Opinion setLess(CharSequence... more) {
/* 56 */     if (more == null || more.length == 0) {
/* 57 */       this.less = dl;
/*    */     } else {
/* 59 */       this.less = more;
/*    */     } 
/* 61 */     return this;
/*    */   }
/*    */   
/*    */   void insert(Str prep, STAT stat, Humanoid a) {
/* 65 */     prep.insert(0, (stat.info()).name);
/* 66 */     BioLine.insert.set(prep, a);
/*    */   }
/*    */   
/*    */   public void read(Json json) {
/* 70 */     if (json.has("MORE"))
/* 71 */       setMore(BioLine.insert.check((CharSequence[])json.texts("MORE"))); 
/* 72 */     if (json.has("LESS"))
/* 73 */       setLess(BioLine.insert.check((CharSequence[])json.texts("LESS"))); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\bio\Opinion.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */