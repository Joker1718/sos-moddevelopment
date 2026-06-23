/*     */ package settlement.room.law.court;
/*     */ 
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class CourtInstance
/*     */   extends RoomInstance
/*     */   implements ROOM_SERVICER {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private short executions;
/*  21 */   private short cellI = 0; private short workCurrent; private final short total; private final short[] cellsXY;
/*  22 */   private short wI = 0;
/*     */   
/*     */   final RoomServiceInstance service;
/*     */   
/*     */   protected CourtInstance(ROOM_COURT b, TmpArea area, RoomInit init) {
/*  27 */     super(b, area, init);
/*     */     
/*  29 */     int spots = 0;
/*  30 */     for (COORDINATE c : body()) {
/*  31 */       if (!is(c))
/*     */         continue; 
/*  33 */       if (CourtStation.isJudge(c)) {
/*  34 */         spots++;
/*     */       }
/*     */     } 
/*     */     
/*  38 */     this.cellsXY = new short[spots * 2];
/*  39 */     this.total = (short)spots;
/*  40 */     this.executions = 0;
/*  41 */     spots = 0;
/*  42 */     int sers = 0;
/*  43 */     for (COORDINATE c : body()) {
/*  44 */       if (is(c)) {
/*  45 */         if (CourtStation.isJudge(c)) {
/*  46 */           this.cellsXY[spots++] = (short)c.x();
/*  47 */           this.cellsXY[spots++] = (short)c.y();
/*     */         } 
/*  49 */         if (Service.init(c.x(), c.y()) != null)
/*  50 */           sers++; 
/*     */       } 
/*     */     } 
/*  53 */     employees().maxSet(this.total);
/*  54 */     employees().neededSet(this.total);
/*  55 */     this.service = new RoomServiceInstance(sers, (RoomService)(blueprintI()).data);
/*  56 */     for (COORDINATE c : body()) {
/*  57 */       if (is(c)) {
/*  58 */         Service.initInit(c.x(), c.y(), this);
/*     */       }
/*     */     } 
/*  61 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  68 */     super.loadFix();
/*     */   }
/*     */   
/*     */   public int total() {
/*  72 */     return this.total;
/*     */   }
/*     */   
/*     */   public int executions() {
/*  76 */     return this.executions;
/*     */   }
/*     */   
/*     */   void inc(int executions, int workCurrent) {
/*  80 */     this.executions = (short)(this.executions + executions);
/*  81 */     this.workCurrent = (short)(this.workCurrent + workCurrent);
/*  82 */     if (active()) {
/*  83 */       blueprintI().incPrisoners(executions, 0);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  90 */     it.lit();
/*  91 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void activateAction() {
/*  96 */     blueprintI().incPrisoners(this.executions, this.total);
/*  97 */     for (COORDINATE c : body()) {
/*  98 */       if (is(c)) {
/*  99 */         Service s = Service.init(c.x(), c.y());
/* 100 */         if (s != null) {
/* 101 */           s.activate();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {
/* 109 */     blueprintI().incPrisoners(-this.executions, -this.total);
/* 110 */     for (COORDINATE c : body()) {
/* 111 */       if (is(c)) {
/* 112 */         Service s = Service.init(c.x(), c.y());
/* 113 */         if (s != null) {
/* 114 */           s.deactivate();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/* 122 */     if (day) {
/* 123 */       this.service.updateDay();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {
/* 130 */     for (COORDINATE c : body()) {
/* 131 */       if (!is(c))
/*     */         continue; 
/* 133 */       FSERVICE s = Service.init(c.x(), c.y());
/* 134 */       if (s != null && s.findableReservedCanBe())
/* 135 */         s.findableReserve(); 
/*     */     } 
/* 137 */     this.service.dispose((RoomService)(blueprintI()).data);
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_COURT blueprintI() {
/* 142 */     return (ROOM_COURT)blueprint();
/*     */   }
/*     */   
/*     */   CourtStation reserveSpot() {
/* 146 */     if (this.executions == this.total)
/* 147 */       throw new RuntimeException(); 
/* 148 */     if (!active())
/* 149 */       throw new RuntimeException(); 
/* 150 */     for (int i = 0; i < this.cellsXY.length; i += 2) {
/* 151 */       this.cellI = (short)(this.cellI + 2);
/* 152 */       if (this.cellI >= this.cellsXY.length)
/* 153 */         this.cellI = 0; 
/* 154 */       int tx = this.cellsXY[this.cellI];
/* 155 */       int ty = this.cellsXY[this.cellI + 1];
/* 156 */       CourtStation s = CourtStation.init(tx, ty);
/* 157 */       if (s.criminalReseveredCanBe()) {
/* 158 */         s.criminalReserve();
/* 159 */         return s;
/*     */       } 
/*     */     } 
/* 162 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   CourtStation work() {
/* 166 */     if (this.workCurrent == 0)
/* 167 */       return null; 
/* 168 */     for (int i = 0; i < this.cellsXY.length; i += 2) {
/* 169 */       this.wI = (short)(this.wI + 2);
/* 170 */       if (this.wI >= this.cellsXY.length)
/* 171 */         this.wI = 0; 
/* 172 */       int tx = this.cellsXY[this.wI];
/* 173 */       int ty = this.cellsXY[this.wI + 1];
/* 174 */       CourtStation s = CourtStation.init(tx, ty);
/* 175 */       if (s.workReservedCanBe()) {
/* 176 */         s.workReserve();
/* 177 */         return s;
/*     */       } 
/*     */     } 
/* 180 */     throw new RuntimeException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomServiceInstance service() {
/* 187 */     return this.service;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double quality() {
/* 194 */     return ROOM_SERVICER.defQuality(this, employees().employed() / employees().max());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\court\CourtInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */