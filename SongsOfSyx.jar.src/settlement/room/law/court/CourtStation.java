/*     */ package settlement.room.law.court;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import snake2d.util.bit.Bit;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ public final class CourtStation {
/*  12 */   private static final Bit workReserved = new Bit(16);
/*  13 */   private static final Bits state = new Bits(15);
/*     */   
/*     */   private static final int STATE_RESERVABLE = 0;
/*     */   private static final int STATE_RESERVED = 1;
/*     */   private static final int STATE_USED = 2;
/*     */   private static final int STATE_JUDGING = 3;
/*  19 */   private final Coo cooCriminal = new Coo();
/*  20 */   private final Coo cooJudge = new Coo();
/*     */   private int rot;
/*     */   private int data;
/*     */   private CourtInstance ins;
/*  24 */   private static final CourtStation self = new CourtStation();
/*     */ 
/*     */   
/*     */   static boolean isJudge(COORDINATE c) {
/*  28 */     int s = (SETT.ROOMS()).fData.tileData.get(c.x(), c.y());
/*  29 */     return (s == 1);
/*     */   }
/*     */   
/*     */   static CourtStation init(int tx, int ty) {
/*  33 */     CourtInstance ins = (CourtInstance)(SETT.ROOMS()).COURT.get(tx, ty);
/*  34 */     if (ins == null)
/*  35 */       return null; 
/*  36 */     int c = (SETT.ROOMS()).fData.tileData.get(tx, ty);
/*  37 */     self.ins = ins;
/*  38 */     if (c == 2) {
/*  39 */       self.cooCriminal.set(tx, ty);
/*  40 */       self.rot = ((FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty)).rotation;
/*  41 */       DIR d = (DIR)DIR.ORTHO.get(self.rot);
/*  42 */       self.cooJudge.set((tx + d.x() * 4), (ty + d.y() * 4));
/*  43 */       self.data = (SETT.ROOMS()).data.get((COORDINATE)self.cooJudge);
/*  44 */       return self;
/*     */     } 
/*  46 */     if (c == 1) {
/*  47 */       self.cooJudge.set(tx, ty);
/*  48 */       self.rot = ((FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty)).rotation;
/*  49 */       DIR d = ((DIR)DIR.ORTHO.get(self.rot)).perpendicular();
/*  50 */       self.cooCriminal.set((tx + d.x() * 4), (ty + d.y() * 4));
/*  51 */       self.data = (SETT.ROOMS()).data.get((COORDINATE)self.cooJudge);
/*  52 */       return self;
/*     */     } 
/*  54 */     return null;
/*     */   }
/*     */   
/*     */   public DIR criminalDir() {
/*  58 */     return (DIR)DIR.ORTHO.get(this.rot);
/*     */   }
/*     */   
/*     */   public DIR jundgeDir() {
/*  62 */     return ((DIR)DIR.ORTHO.get(this.rot)).perpendicular();
/*     */   }
/*     */   
/*     */   public boolean criminalReseveredCanBe() {
/*  66 */     return (state.get(this.data) == 0);
/*     */   }
/*     */   
/*     */   void criminalReserve() {
/*  70 */     if (!criminalReseveredCanBe())
/*  71 */       throw new RuntimeException(); 
/*  72 */     this.data = state.set(this.data, 1);
/*  73 */     save();
/*     */   }
/*     */   
/*     */   public boolean criminalReserved() {
/*  77 */     return (state.get(this.data) >= 1);
/*     */   }
/*     */   
/*     */   public boolean criminalIsUsing() {
/*  81 */     return (state.get(this.data) == 2);
/*     */   }
/*     */   
/*     */   public void criminalUse() {
/*  85 */     this.data = state.set(this.data, 2);
/*  86 */     save();
/*     */   }
/*     */   
/*     */   public void criminalClear() {
/*  90 */     this.data = state.set(this.data, 0);
/*  91 */     save();
/*     */   }
/*     */   
/*     */   boolean workReservedCanBe() {
/*  95 */     return (!workReserved.is(this.data) && state.get(this.data) > 1);
/*     */   }
/*     */   
/*     */   void workReserve() {
/*  99 */     this.data = workReserved.set(this.data);
/* 100 */     save();
/*     */   }
/*     */   
/*     */   public void workUse() {
/* 104 */     this.data = state.set(this.data, 3);
/* 105 */     save();
/*     */   }
/*     */   
/*     */   public boolean criminalIsBeeingHeard() {
/* 109 */     return (state.get(this.data) == 3);
/*     */   }
/*     */   
/*     */   public void workCancel() {
/* 113 */     this.data = workReserved.clear(this.data);
/* 114 */     save();
/*     */   }
/*     */   
/*     */   public boolean workReserved() {
/* 118 */     if (state.get(this.data) <= 1)
/* 119 */       workCancel(); 
/* 120 */     return workReserved.is(this.data);
/*     */   }
/*     */   
/*     */   private void save() {
/* 124 */     add((SETT.ROOMS()).data.get(this.cooJudge.x(), this.cooJudge.y()), -1);
/* 125 */     add(this.data, 1);
/* 126 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.cooJudge, this.data);
/*     */   }
/*     */   
/*     */   private void add(int data, int delta) {
/* 130 */     if (state.get(data) != 0)
/* 131 */       this.ins.inc(delta, 0); 
/* 132 */     if (!workReserved.is(data) && state.get(data) > 1)
/* 133 */       this.ins.inc(0, delta); 
/*     */   }
/*     */   
/*     */   public COORDINATE cooJudge() {
/* 137 */     return (COORDINATE)this.cooJudge;
/*     */   }
/*     */   
/*     */   public COORDINATE cooCriminal() {
/* 141 */     return (COORDINATE)this.cooCriminal;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\court\CourtStation.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */