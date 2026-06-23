/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.environment.SettEnvMap;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Updater
/*     */   implements StatsInit.StatUpdatableI
/*     */ {
/*     */   private final ArrayList<SettEnvMap.SettEnv> alle;
/*     */   
/*     */   private Updater() {
/*  78 */     this.alle = new ArrayList((Iterable)(SETT.ENV()).map.all());
/*     */     
/*  80 */     this.alle.remove((SETT.ENV()).map.NOISE);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update16(Humanoid h, int updateI, boolean day, int ui) {
/*  86 */     Induvidual i = h.indu();
/*     */     
/*  88 */     if (!HPoll.Handler.works(h) || (STATS.WORK()).EMPLOYED.get(h) == null || 
/*  89 */       !((RoomInstance)(STATS.WORK()).EMPLOYED.get(h)).constructor().envValue((SETT.ENV()).map.NOISE)) {
/*  90 */       SettEnvMap.SettEnv e = (SETT.ENV()).map.NOISE;
/*  91 */       accessCheck2(h, ((STAT)StatsAccess.this.ACCESS.all().get(e.index())).indu(), e.get(h.physics.tileC()) * 16.0D, e.declineSpeed);
/*     */     } 
/*     */     
/*  94 */     RoomBlueprint room = (RoomBlueprint)(SETT.ROOMS()).map.blueprint.get(h.physics.tileC());
/*  95 */     if (room == null || room.registersEnvironment()) {
/*  96 */       boolean deg = false;
/*  97 */       for (StatsAccess.StatMonument m : StatsAccess.this.MONUMENTS.ALL) {
/*  98 */         int a = m.m.mapData.get(h.physics.tileC());
/*  99 */         int c = m.amount.indu().get(i);
/* 100 */         if (a > 0) {
/* 101 */           m.access.indu().set(i, 1);
/* 102 */           deg |= (SETT.ENV()).map.MONUMENT.DEGRADE.is(h.tc());
/* 103 */           int up = m.m.mapUpgrade.get(h.physics.tileC());
/* 104 */           m.upgrade.indu().set(h.indu(), up);
/*     */         } 
/*     */         
/* 107 */         if (a > c) {
/* 108 */           m.amount.indu().inc(h.indu(), 1); continue;
/* 109 */         }  if (a < c) {
/* 110 */           if (m.amount.indu().get(i) == 0) {
/* 111 */             m.access.indu().set(i, 0);
/* 112 */             m.upgrade.indu().set(h.indu(), 0); continue;
/*     */           } 
/* 114 */           m.amount.indu().inc(h.indu(), -1);
/*     */         } 
/*     */       } 
/* 117 */       StatsAccess.this.MONUMENTS.degrade.indu().set(i, deg ? 1 : 0);
/*     */ 
/*     */       
/* 120 */       for (SettEnvMap.SettEnv e : this.alle) {
/* 121 */         accessCheck(h, ((STAT)StatsAccess.this.ACCESS.all().get(e.index())).indu(), e.get(h.physics.tileC()) * 16.0D, e.declineSpeed);
/*     */       }
/*     */ 
/*     */       
/* 125 */       for (StatsAccess.Env ee : StatsAccess.this.ACCESS.envs) {
/* 126 */         if (ee.t.is(h.physics.tileC())) {
/* 127 */           ee.stat.indu().inc(h.indu(), 1);
/* 128 */           for (StatsAccess.Env e : StatsAccess.this.ACCESS.envs) {
/* 129 */             if (e == ee)
/*     */               continue; 
/* 131 */             e.stat.indu().inc(h.indu(), -1);
/*     */           } 
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void accessCheck(Humanoid h, INT_O.INT_OE<Induvidual> data, double value, double deg) {
/* 140 */     Induvidual i = h.indu();
/* 141 */     int v = (int)Math.ceil(value);
/* 142 */     if (v > data.get(i) * 2)
/* 143 */       data.inc(i, 2); 
/* 144 */     if (v > data.get(i)) {
/* 145 */       data.inc(i, 1);
/* 146 */     } else if (v < data.get(i) && RND.oneIn(8.0D * 1.0D / deg)) {
/* 147 */       data.inc(i, -1);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void accessCheck2(Humanoid h, INT_O.INT_OE<Induvidual> data, double value, double deg) {
/* 152 */     Induvidual i = h.indu();
/* 153 */     int v = (int)Math.ceil(value);
/* 154 */     if (v > data.get(i))
/* 155 */       data.inc(i, 1); 
/* 156 */     if (v < data.get(i))
/* 157 */       data.inc(i, -1); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsAccess$Updater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */