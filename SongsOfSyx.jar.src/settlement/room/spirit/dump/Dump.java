/*     */ package settlement.room.spirit.dump;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import settlement.entity.humanoid.spirte.HCorpseRenderer;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.thing.ThingsCorpses;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.bit.Bit;
/*     */ import snake2d.util.bit.Bits;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ class Dump
/*     */   implements FSERVICE {
/*  18 */   private static final Bit is = new Bit(1);
/*  19 */   private static final Bit reserved = new Bit(2);
/*  20 */   private static final Bits time = new Bits(252);
/*  21 */   private static final Bits race = new Bits(65280);
/*  22 */   private static final Bit active = new Bit(65536);
/*     */   
/*  24 */   private static Dump self = new Dump();
/*     */   
/*     */   private int tx;
/*     */   
/*     */   private int ty;
/*     */   
/*     */   private int data;
/*     */   
/*     */   private DumpInstance ins;
/*     */ 
/*     */   
/*     */   static void init(DumpInstance ins, int tx, int ty) {
/*  36 */     (SETT.ROOMS()).data.set((ROOMA)ins, tx, ty, is.set(0));
/*     */   }
/*     */   
/*     */   static void activate(int tx, int ty) {
/*  40 */     if (get(tx, ty) != null) {
/*  41 */       self.data = active.set(self.data);
/*  42 */       self.data = reserved.clear(self.data);
/*  43 */       self.save();
/*     */     } 
/*     */   }
/*     */   
/*     */   static void deactivate(int tx, int ty) {
/*  48 */     if (get(tx, ty) != null) {
/*  49 */       self.data = active.clear(self.data);
/*  50 */       self.data = reserved.clear(self.data);
/*  51 */       self.save();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static int daysTillDecompose(int tx, int ty) {
/*  57 */     if (get(tx, ty) != null) {
/*  58 */       return time.get(self.data);
/*     */     }
/*  60 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   static Dump get(int tx, int ty) {
/*  65 */     self.ins = (DumpInstance)(SETT.ROOMS()).DUMP.getter.get(tx, ty);
/*  66 */     if (self.ins != null) {
/*  67 */       self.data = (SETT.ROOMS()).data.get(tx, ty);
/*  68 */       if (is.is(self.data)) {
/*  69 */         self.tx = tx;
/*  70 */         self.ty = ty;
/*  71 */         return self;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  76 */     return null;
/*     */   }
/*     */   
/*     */   private void save() {
/*  80 */     int now = this.data;
/*  81 */     this.data = (SETT.ROOMS()).data.get(this.tx, this.ty);
/*  82 */     this.ins.service().report(this, this.ins.blueprintI().service(), -1);
/*  83 */     this.data = now;
/*  84 */     this.ins.service().report(this, this.ins.blueprintI().service(), 1);
/*  85 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, this.tx, this.ty, this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/*  90 */     return (active.is(this.data) && time.get(this.data) == 0 && !reserved.is(this.data));
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/*  95 */     if (!findableReservedCanBe())
/*  96 */       throw new RuntimeException(); 
/*  97 */     this.data = reserved.set(this.data);
/*  98 */     save();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/* 103 */     return (active.is(this.data) && reserved.is(this.data));
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 108 */     this.data = reserved.clear(this.data);
/* 109 */     save();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int x() {
/* 115 */     return this.tx;
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/* 120 */     return this.ty;
/*     */   }
/*     */ 
/*     */   
/*     */   public void consume() {
/* 125 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   void burry(ThingsCorpses.Corpse corpse) {
/* 129 */     boolean a = active.is(this.data);
/* 130 */     this.data = is.set(0);
/* 131 */     this.data = race.set(this.data, (corpse.indu().race()).index);
/* 132 */     this.data = time.set(this.data, 16);
/* 133 */     this.data = reserved.clear(this.data);
/* 134 */     this.data = active.set(this.data, a);
/* 135 */     save();
/*     */   }
/*     */   
/*     */   void update() {
/* 139 */     if (time.get(this.data) > 0) {
/* 140 */       this.data = time.inc(this.data, -1);
/* 141 */       if (time.get(this.data) == 0)
/* 142 */         this.data = reserved.clear(this.data); 
/* 143 */       save();
/*     */     } 
/*     */   }
/*     */   
/*     */   static void render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 148 */     int data = (SETT.ROOMS()).data.get(i.tile());
/* 149 */     if (is.is(data)) {
/* 150 */       int t = time.get(data);
/* 151 */       if (t > 0) {
/*     */         
/* 153 */         double deg = 0.5D + (16 - t) / 8.0D;
/* 154 */         Race rr = (Race)RACES.all().get(race.get(data));
/* 155 */         int ran = i.ran();
/* 156 */         int di = ran & 0x7;
/* 157 */         ran >>= 3;
/* 158 */         int dx = -4 + (ran & 0x7);
/* 159 */         ran >>= 4;
/* 160 */         int dy = -4 + (ran & 0x7);
/* 161 */         ran >>= 4;
/*     */         
/* 163 */         if (deg > 1.0D) {
/* 164 */           HCorpseRenderer.renderSkelleton(rr, true, di, false, r, shadowBatch, ran, i.x() + dx * 4, i.y() + dy * 4);
/*     */         } else {
/* 166 */           HCorpseRenderer.renderDump(rr, deg, di, r, shadowBatch, ran, i.x() + dx * 4, i.y() + dy * 4);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\dump\Dump.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */