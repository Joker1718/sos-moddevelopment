/*     */ package game.battle.div;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.constant.Config;
/*     */ import init.race.Race;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class DivReporter
/*     */   extends StatsBattle.HDivStat
/*     */ {
/* 156 */   private final Bitmap1D unreachablem = new Bitmap1D((Config.battle()).MEN_PER_DIVISION, false);
/*     */ 
/*     */   
/*     */   private short unreachable;
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean posHas(Humanoid a) {
/* 164 */     return (Div.this.position().deployed() >= Div.this.men.getSpot(a.divSpot()));
/*     */   }
/*     */   
/*     */   public COORDINATE getTile(Humanoid a) {
/* 168 */     COORDINATE c = Div.this.position().tile(Div.this.men.getSpot(a.divSpot()));
/* 169 */     if (c == null)
/* 170 */       return a.tc(); 
/* 171 */     return c;
/*     */   }
/*     */   
/*     */   public COORDINATE getPixel(Humanoid a) {
/* 175 */     COORDINATE c = Div.this.position().pixel(Div.this.men.getSpot(a.divSpot()));
/* 176 */     if (c == null) {
/* 177 */       Div.tmp.set(a.body().cX(), a.body().cY());
/* 178 */       return (COORDINATE)Div.tmp;
/*     */     } 
/* 180 */     return c;
/*     */   }
/*     */   
/*     */   public RECTANGLE body() {
/* 184 */     return Div.this.position().body();
/*     */   }
/*     */   
/*     */   public COORDINATE getDestTile(Humanoid a) {
/* 188 */     COORDINATE c = Div.this.position().centreTile();
/* 189 */     if (c == null)
/* 190 */       return a.tc(); 
/* 191 */     return c;
/*     */   }
/*     */   
/*     */   public void reportPosition(short spot, int x, int y) {
/* 195 */     Div.this.current.set(Div.this.men.getSpot(spot), x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public short signUpAndGetPosition(int x, int y, Race r) {
/* 200 */     if (Div.this.menNrOf() == 0) {
/* 201 */       Div.this.info.raceSet(r);
/* 202 */       (GAME.ARMIES()).factors.init(Div.this);
/*     */     } 
/* 204 */     Div.this.army.men.recount();
/* 205 */     short sp = Div.this.men.getNewSpot();
/* 206 */     reportPosition(sp, x, y);
/* 207 */     Div.this.current.init(Div.this.men.men());
/*     */     
/* 209 */     return sp;
/*     */   }
/*     */ 
/*     */   
/*     */   public void returnPosition(short pos) {
/* 214 */     Div.this.army.men.recount();
/* 215 */     Div.this.men.returnSpot(pos);
/* 216 */     if (Div.this.men.men() == 0)
/* 217 */       Div.this.settings().musteringSet(false); 
/* 218 */     reportReachable(pos, true);
/* 219 */     Div.this.current.init(Div.this.men.men());
/*     */   }
/*     */   
/*     */   private void reportReachable(int spot, boolean reachable) {
/* 223 */     if (this.unreachablem.get(spot))
/* 224 */       this.unreachable = (short)(this.unreachable - 1); 
/* 225 */     this.unreachablem.set(spot, !reachable);
/* 226 */     if (!reachable) {
/* 227 */       this.unreachable = (short)(this.unreachable + 1);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reportReachable(Humanoid a, boolean reachable) {
/* 232 */     int spot = positionSpot(a);
/* 233 */     reportReachable(spot, reachable);
/*     */   }
/*     */   
/*     */   public boolean reachable(int i) {
/* 237 */     return !this.unreachablem.get(i);
/*     */   }
/*     */   
/*     */   public int unreachable() {
/* 241 */     return this.unreachable;
/*     */   }
/*     */   
/*     */   public int positionSpot(Humanoid h) {
/* 245 */     int i = STATS.BATTLE().position(h.indu());
/* 246 */     return Div.this.men.getSpot(i);
/*     */   }
/*     */   
/*     */   public int positionSpot(int ui) {
/* 250 */     return Div.this.men.spotTranslate(ui);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\div\Div$DivReporter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */