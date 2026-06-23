/*    */ package settlement.room.military.supply;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import game.time.TIME;
/*    */ import init.resources.RESOURCE;
/*    */ import init.resources.RESOURCES;
/*    */ import java.io.IOException;
/*    */ import java.util.Arrays;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import world.army.AD;
/*    */ import world.army.ADSupply;
/*    */ import world.entity.army.WArmy;
/*    */ 
/*    */ final class Cache
/*    */   implements SAVABLE {
/* 19 */   private double[] lockedUntil = new double[RESOURCES.ALL().size()];
/*    */   
/* 21 */   private int debugAmount = 0;
/*    */ 
/*    */   
/*    */   Cache(ROOM_SUPPLY b) {}
/*    */ 
/*    */   
/*    */   public int needed(RESOURCE res) {
/* 28 */     int am = 0;
/* 29 */     for (ADSupply a : AD.supplies().get(res))
/* 30 */       am = (int)(am + a.needed((Faction)FACTIONS.player())); 
/* 31 */     return am + this.debugAmount;
/*    */   }
/*    */ 
/*    */   
/*    */   public int deliverableSecret(RESOURCE res) {
/* 36 */     int needed = 0;
/* 37 */     for (ADSupply s : AD.supplies().get(res)) {
/* 38 */       for (WArmy e : FACTIONS.player().armies().all()) {
/* 39 */         needed = (int)(needed + s.needed(e));
/*    */       }
/*    */     } 
/* 42 */     needed += this.debugAmount;
/* 43 */     return needed;
/*    */   }
/*    */   
/*    */   public int deliverable(RESOURCE res) {
/* 47 */     if (this.lockedUntil[res.index()] > TIME.currentSecond())
/* 48 */       return 0; 
/* 49 */     int needed = deliverableSecret(res);
/* 50 */     if (needed <= 0) {
/* 51 */       this.lockedUntil[res.index()] = TIME.currentSecond() + TIME.secondsPerDay() * 0.25D;
/* 52 */       return 0;
/*    */     } 
/* 54 */     return needed;
/*    */   }
/*    */ 
/*    */   
/*    */   public int deliver(RESOURCE res, int am) {
/* 59 */     if (this.debugAmount != 0) {
/* 60 */       return am;
/*    */     }
/* 62 */     double needed = deliverable(res);
/* 63 */     if (needed <= 0.0D) {
/* 64 */       return 0;
/*    */     }
/* 66 */     int delivered = 0;
/* 67 */     for (ADSupply s : AD.supplies().get(res)) {
/* 68 */       for (WArmy e : FACTIONS.player().armies().all()) {
/* 69 */         double n = s.needed(e);
/* 70 */         n /= needed;
/* 71 */         int a = (int)Math.ceil(am * n);
/* 72 */         if (a > am)
/* 73 */           a = am; 
/* 74 */         delivered += a;
/* 75 */         s.current().inc(e, a);
/*    */       } 
/*    */     } 
/* 78 */     return delivered;
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 83 */     file.dsE(this.lockedUntil);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 88 */     file.dsE(this.lockedUntil);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void clear() {
/* 94 */     Arrays.fill(this.lockedUntil, 0.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\supply\Cache.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */