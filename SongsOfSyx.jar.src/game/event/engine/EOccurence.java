/*    */ package game.event.engine;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import game.time.TIME;
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import init.type.CLIMATE;
/*    */ import init.type.CLIMATES;
/*    */ import init.type.TERRAIN;
/*    */ import init.type.TERRAINS;
/*    */ import init.value.GVALUES;
/*    */ import init.value.Lockable;
/*    */ import settlement.main.SETT;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.file.Json;
/*    */ 
/*    */ final class EOccurence
/*    */ {
/* 19 */   public final Lockable<Faction> plockable = GVALUES.FACTION.LOCK.push();
/* 20 */   public final double[] coccurence = new double[CLIMATES.ALL().size()];
/* 21 */   public final double[] roccurence = new double[RACES.all().size()];
/* 22 */   public final double[] toccurence = new double[TERRAINS.ALL().size()];
/*    */   
/*    */   public final int maxSpawns;
/*    */   
/*    */   public double onlyAfterTime;
/*    */   
/*    */   public EOccurence(Json data, EventCollection engine, Event parent) {
/* 29 */     if (data.has("OCCURENCE")) {
/* 30 */       data = data.json("OCCURENCE");
/* 31 */       data.value("TYPE", "");
/* 32 */       CLIMATES.MAP().readFill("CLIMATE", this.coccurence, data, 0.0D, 1.0E7D);
/* 33 */       RACES.map().readFill("RACE", this.roccurence, data, 0.0D, 1.0E7D);
/* 34 */       TERRAINS.MAP().readFill("TERRAIN", this.toccurence, data, 0.0D, 100000.0D);
/* 35 */       this.maxSpawns = data.i("MAX_SPAWNS", 0, 2147483647, 2147483647);
/*    */       
/* 37 */       this.onlyAfterTime = data.dTry("ONLY_AFTER_DAYS", 0.0D, 100000.0D, 0.0D) * TIME.secondsPerDay();
/* 38 */       this.plockable.push(data);
/* 39 */       data.checkUnused();
/*    */     } else {
/*    */       
/* 42 */       this.maxSpawns = 10;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public double occurence(Race race) {
/* 49 */     double occ = 0.0D;
/*    */     
/* 51 */     for (TERRAIN t : TERRAINS.ALL()) {
/* 52 */       occ += this.toccurence[t.index()] * (SETT.WORLD_AREA()).info.get(t).getD();
/*    */     }
/* 54 */     CLIMATE climate = SETT.ENV().climate();
/* 55 */     occ *= this.coccurence[climate.index()] * this.roccurence[race.index()];
/* 56 */     return occ;
/*    */   }
/*    */   
/*    */   public double race(Race race) {
/* 60 */     return this.roccurence[race.index()];
/*    */   }
/*    */   
/*    */   public double occurence() {
/* 64 */     double occ = 0.0D;
/*    */     
/* 66 */     for (TERRAIN t : TERRAINS.ALL()) {
/* 67 */       double d = this.toccurence[t.index()] * (SETT.WORLD_AREA()).info.get(t).getD();
/* 68 */       if (d > occ) {
/* 69 */         occ = d;
/*    */       }
/*    */     } 
/* 72 */     double raM = 0.0D;
/* 73 */     double tot = (1 + (STATS.POP()).POP.data(null).get(null));
/* 74 */     for (Race r : RACES.all()) {
/* 75 */       double d = this.roccurence[r.index()] * (STATS.POP()).POP.data().get(r) / tot;
/* 76 */       if (d > raM)
/* 77 */         raM = d; 
/*    */     } 
/* 79 */     occ *= this.coccurence[SETT.ENV().climate().index()] * raM;
/* 80 */     return occ;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\EOccurence.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */