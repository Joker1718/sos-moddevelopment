/*     */ package game.faction.player;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PlayerRaces
/*     */ {
/* 231 */   private final int[] order = Alloc.ii(RACES.all().size());
/*     */   
/* 233 */   final SAVABLE saver = new SAVABLE()
/*     */     {
/*     */       public void save(FilePutter file)
/*     */       {
/* 237 */         file.isE(Player.PlayerRaces.this.order);
/*     */       }
/*     */ 
/*     */       
/*     */       public void load(FileGetter file) throws IOException {
/* 242 */         if (!file.isE(Player.PlayerRaces.this.order)) {
/* 243 */           Player.PlayerRaces.this.set(FACTIONS.player().race());
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void clear() {}
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   void set(Race player) {
/* 255 */     this.order[0] = player.index;
/* 256 */     int playable = 1;
/*     */     
/* 258 */     for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 259 */       Race r = (Race)RACES.all().get(ri);
/* 260 */       if (r != player && r.playable) {
/* 261 */         playable++;
/*     */       }
/*     */     } 
/* 264 */     int i = 1;
/* 265 */     for (int j = 0; j < RACES.all().size(); j++) {
/* 266 */       Race r = (Race)RACES.all().get(j);
/* 267 */       if (r != player && r.playable) {
/* 268 */         this.order[i++] = r.index;
/* 269 */       } else if (r != player) {
/* 270 */         this.order[playable++] = r.index;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   PlayerRaces() {
/* 278 */     int playable = 0;
/* 279 */     for (Race r : RACES.all()) {
/* 280 */       if (r.playable) {
/* 281 */         playable++;
/*     */       }
/*     */     } 
/* 284 */     int i = 0;
/* 285 */     for (Race r : RACES.all()) {
/* 286 */       if (r.playable) {
/* 287 */         this.order[i++] = r.index; continue;
/*     */       } 
/* 289 */       this.order[playable++] = r.index;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void order(Race r, int index) {
/* 297 */     int i = 0;
/* 298 */     for (; i < this.order.length && 
/* 299 */       this.order[i] != r.index; i++);
/*     */ 
/*     */ 
/*     */     
/* 303 */     for (; i < this.order.length - 1; i++) {
/* 304 */       this.order[i] = this.order[i + 1];
/*     */     }
/* 306 */     for (i = this.order.length - 1; i > index; i--) {
/* 307 */       this.order[i] = this.order[i - 1];
/*     */     }
/* 309 */     this.order[index] = r.index;
/*     */   }
/*     */ 
/*     */   
/*     */   public Race get(int index) {
/* 314 */     if (index < 0)
/* 315 */       return null; 
/* 316 */     return (Race)RACES.all().get(this.order[index]);
/*     */   }
/*     */   
/*     */   public int size() {
/* 320 */     return this.order.length;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\Player$PlayerRaces.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */