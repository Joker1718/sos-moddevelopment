/*     */ package game.tourism;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.Inserter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends Inserter<Text.InsertData>.II
/*     */ {
/*     */   null(Inserter paramInserter, String $anonymous0) {
/* 107 */     super(paramInserter, $anonymous0);
/*     */   }
/*     */   
/*     */   public void set(Text.InsertData t, Str str) {
/* 111 */     RoomInstance ins = (RoomInstance)(SETT.ROOMS()).INN.getter.get(t.inn);
/* 112 */     if (ins == null) {
/*     */       return;
/*     */     }
/* 115 */     if (ins.employees().employed() > 0) {
/* 116 */       int e = (int)(ins.employees().employed() * RND.rFloat());
/* 117 */       for (Humanoid a : ins.employees().employees()) {
/* 118 */         if (e-- <= 0) {
/* 119 */           str.add(STATS.APPEARANCE().name(a.indu()));
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/* 124 */     str.add(STATS.APPEARANCE().name((Race)RACES.all().rnd(), HTYPES.SUBJECT(), 0, RND.rInt()));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\tourism\Text$9.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */