/*     */ package settlement.room.infra.station;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.main.SETT;
/*     */ 
/*     */ 
/*     */ public class StationTally
/*     */ {
/*   9 */   private byte crates = 0;
/*  10 */   private int stored = 0;
/*  11 */   private int reserved = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void remove(RESOURCE res, Crate crate, StationInstance ins) {
/*  18 */     (SETT.ROOMS()).STATION.tally(crate.resource()).remove(this, ins);
/*  19 */     this.crates = (byte)(this.crates - 1);
/*  20 */     this.stored -= crate.stored.get();
/*  21 */     this.reserved -= crate.reserved.get();
/*  22 */     ins.bamount.set(res, (this.stored - this.reserved >= 0));
/*  23 */     ins.bcapacity.set(res, (this.crates >= 0));
/*     */   }
/*     */ 
/*     */   
/*     */   void add(RESOURCE res, Crate crate, StationInstance ins) {
/*  28 */     this.crates = (byte)(this.crates + 1);
/*  29 */     this.stored += crate.stored.get();
/*  30 */     this.reserved += crate.reserved.get();
/*  31 */     ins.bamount.set(res, (this.stored - this.reserved >= 0));
/*  32 */     ins.bcapacity.set(res, (this.crates >= 0));
/*  33 */     (SETT.ROOMS()).STATION.tally(crate.resource()).add(this, ins);
/*     */   }
/*     */   
/*     */   public int stored() {
/*  37 */     return this.stored;
/*     */   }
/*     */   
/*     */   public int reserved() {
/*  41 */     return this.reserved;
/*     */   }
/*     */   
/*     */   public int crates() {
/*  45 */     return this.crates;
/*     */   }
/*     */   
/*     */   public int space() {
/*  49 */     (SETT.ROOMS()).STATION.crate.getClass(); return this.crates * 400;
/*     */   }
/*     */   
/*     */   public int spaceAvailable() {
/*  53 */     (SETT.ROOMS()).STATION.crate.getClass(); return this.crates * 400 - this.stored;
/*     */   }
/*     */   
/*     */   void clear() {
/*  57 */     this.crates = 0;
/*  58 */     this.stored = 0;
/*  59 */     this.reserved = 0;
/*     */   }
/*     */   
/*     */   public static class Total
/*     */   {
/*  64 */     private byte crates = 0;
/*  65 */     private int stored = 0;
/*  66 */     private int reserved = 0;
/*  67 */     private int incoming = 0;
/*  68 */     private int available = 0;
/*     */     public final RESOURCE res;
/*     */     
/*     */     Total(RESOURCE res) {
/*  72 */       this.res = res;
/*     */     }
/*     */     
/*     */     void remove(StationTally crate, StationInstance ins) {
/*  76 */       if (ins.accepting(this.res))
/*  77 */         this.available--; 
/*  78 */       this.crates = (byte)(this.crates - crate.crates);
/*  79 */       this.stored -= crate.stored;
/*  80 */       this.reserved -= crate.reserved;
/*  81 */       this.incoming -= ins.incoming(this.res);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void add(StationTally crate, StationInstance ins) {
/*  87 */       this.crates = (byte)(this.crates + crate.crates);
/*  88 */       this.stored += crate.stored;
/*  89 */       this.reserved += crate.reserved;
/*  90 */       this.incoming += ins.incoming(this.res);
/*  91 */       if (ins.accepting(this.res)) {
/*  92 */         this.available++;
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     void debug() {
/*  98 */       int am = 0;
/*  99 */       for (int i = 0; i < (SETT.ROOMS()).STATION.instancesSize(); i++) {
/* 100 */         StationInstance ins = (StationInstance)(SETT.ROOMS()).STATION.getInstance(i);
/* 101 */         if (ins.tally == null)
/*     */           return; 
/* 103 */         if (ins.accepting(this.res))
/* 104 */           am++; 
/*     */       } 
/* 106 */       if (am != this.available)
/* 107 */         throw new RuntimeException(String.valueOf(this.res) + " " + String.valueOf(this.res) + " " + am); 
/*     */     }
/*     */     
/*     */     public int stored() {
/* 111 */       return this.stored;
/*     */     }
/*     */     
/*     */     public int reserved() {
/* 115 */       return this.reserved;
/*     */     }
/*     */     
/*     */     public int incoming() {
/* 119 */       return this.incoming;
/*     */     }
/*     */     
/*     */     public int crates() {
/* 123 */       return this.crates;
/*     */     }
/*     */     
/*     */     public int space() {
/* 127 */       return this.crates * 400;
/*     */     }
/*     */     
/*     */     public int accepting() {
/* 131 */       return this.available;
/*     */     }
/*     */     
/*     */     void clear() {
/* 135 */       this.crates = 0;
/* 136 */       this.stored = 0;
/* 137 */       this.reserved = 0;
/* 138 */       this.available = 0;
/* 139 */       this.incoming = 0;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\station\StationTally.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */