/*     */ package init.race;
/*     */ 
/*     */ import game.faction.npc.FactionNPC;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Message
/*     */ {
/*     */   private final CharSequence[] all;
/*     */   public final String key;
/*     */   private ACTION da;
/*     */   
/*     */   Message(Json j, String key) {
/* 201 */     this.da = new ACTION()
/*     */       {
/* 203 */         int ii = 0;
/*     */ 
/*     */         
/*     */         public void exe() {
/* 207 */           CharSequence m = KingMessages.Message.this.get((KingMessages.Message.access$0(KingMessages.Message.this)).debug, this.ii);
/* 208 */           this.ii++;
/* 209 */           if (this.ii >= KingMessages.Message.this.all.length)
/* 210 */             this.ii = 0; 
/* 211 */           LOG.ln(m);
/*     */         }
/*     */       };
/*     */     this.all = KingMessages.insert.check((CharSequence[])j.texts(key));
/*     */     paramKingMessages.all.add(this);
/*     */     this.key = key;
/*     */   }
/*     */   
/*     */   public CharSequence get(FactionNPC f) {
/*     */     return get(f, RND.rInt(this.all.length));
/*     */   }
/*     */   
/*     */   private CharSequence get(FactionNPC f, int mi) {
/*     */     KingMessages.TMP.clear();
/*     */     KingMessages.TMP.add(this.all[mi]);
/*     */     KingMessages.insert.set(KingMessages.TMP, f);
/*     */     return (CharSequence)KingMessages.TMP;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\KingMessages$Message.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */