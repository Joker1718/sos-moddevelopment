/*     */ package settlement.room.main.util;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.type.WGROUP;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.industry.module.ROOM_PRODUCER_INSTANCE;
/*     */ import settlement.room.industry.module.consumption.RoomConsumption;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.job.ROOM_EMPLOY_AUTO;
/*     */ import settlement.room.main.job.ROOM_RADIUS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoomStateInstance
/*     */   extends RoomState
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final int workersTarget;
/*     */   private final int industry;
/*     */   private boolean auto;
/*     */   private byte radius;
/*     */   private int consumptionMask;
/*     */   private String name;
/*  36 */   private final WGROUP.HTypeBitsImp pref = new WGROUP.HTypeBitsImp(false);
/*     */ 
/*     */   
/*     */   public RoomStateInstance(RoomInstance ins) {
/*  40 */     this.name = String.valueOf(ins.name());
/*     */     
/*  42 */     this.pref.copy(ins.employees().preffered());
/*     */     
/*  44 */     this.workersTarget = ins.employees().hardTarget();
/*  45 */     if (ins.blueprintI() instanceof ROOM_EMPLOY_AUTO) {
/*  46 */       ROOM_EMPLOY_AUTO a = (ROOM_EMPLOY_AUTO)ins.blueprintI();
/*  47 */       this.auto = a.autoEmploy((Room)ins);
/*     */     } 
/*  49 */     if (ins instanceof ROOM_PRODUCER_INSTANCE) {
/*  50 */       this.industry = ((ROOM_PRODUCER_INSTANCE)ins).industryI();
/*     */     } else {
/*  52 */       this.industry = 0;
/*     */     } 
/*  54 */     if (ins instanceof ROOM_RADIUS.ROOM_RADIUS_INSTANCE)
/*  55 */       this.radius = ((ROOM_RADIUS.ROOM_RADIUS_INSTANCE)ins).radiusRaw(); 
/*  56 */     if (ins.blueprintI() instanceof RoomConsumption.ROOM_CONSUMPTION_HASER) {
/*  57 */       RoomConsumption ii = ((RoomConsumption.ROOM_CONSUMPTION_HASER)ins.blueprintI()).consumption();
/*  58 */       for (int i = 0; i < ii.ins().size(); i++) {
/*  59 */         if (ii.enabled((IndustryResource)ii.ins().get(i), (ROOM_IDATA_INSTANCE)ins)) {
/*  60 */           this.consumptionMask |= 1 << i;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void apply(Room room, int tx, int ty) {
/*  69 */     if (!(room instanceof RoomInstance)) {
/*     */       return;
/*     */     }
/*  72 */     RoomInstance ins = (RoomInstance)room;
/*     */     
/*  74 */     if (ins.blueprintI().employment() != null) {
/*  75 */       ins.employees().neededSet(this.workersTarget);
/*     */     }
/*  77 */     if (ins.blueprintI() instanceof ROOM_EMPLOY_AUTO) {
/*  78 */       ROOM_EMPLOY_AUTO a = (ROOM_EMPLOY_AUTO)ins.blueprintI();
/*  79 */       a.autoEmploy((Room)ins, this.auto);
/*     */     } 
/*  81 */     if (ins instanceof ROOM_PRODUCER_INSTANCE && ins.blueprint() instanceof INDUSTRY_HASER) {
/*  82 */       INDUSTRY_HASER h = (INDUSTRY_HASER)ins.blueprint();
/*  83 */       if (this.industry >= 0 && this.industry < h.industries().size() && ((Industry)h.industries().getC(this.industry)).lockable().passes(FACTIONS.player()))
/*  84 */         ((ROOM_PRODUCER_INSTANCE)ins).setIndustry(this.industry); 
/*     */     } 
/*  86 */     if (ins instanceof ROOM_RADIUS.ROOM_RADIUS_INSTANCE)
/*  87 */       ((ROOM_RADIUS.ROOM_RADIUS_INSTANCE)ins).radiusRawSet(this.radius); 
/*  88 */     if (ins.blueprintI() instanceof RoomConsumption.ROOM_CONSUMPTION_HASER) {
/*  89 */       RoomConsumption ii = ((RoomConsumption.ROOM_CONSUMPTION_HASER)ins.blueprintI()).consumption();
/*  90 */       for (int i = 0; i < ii.ins().size(); i++) {
/*  91 */         boolean e = ((this.consumptionMask & 1 << i) != 0);
/*  92 */         if (e != ii.enabled((IndustryResource)ii.ins().get(i), (ROOM_IDATA_INSTANCE)ins)) {
/*  93 */           ii.enabledToggle((IndustryResource)ii.ins().get(i), (ROOM_IDATA_INSTANCE)ins, ins);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  98 */     applyIns(ins);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void applyIns(RoomInstance ins) {}
/*     */ 
/*     */   
/*     */   public void applyRepaired(Room room, int tx, int ty) {
/* 107 */     if (!(room instanceof RoomInstance))
/*     */       return; 
/* 109 */     RoomInstance ins = (RoomInstance)room;
/* 110 */     ins.name().clear().add(this.name);
/* 111 */     if (ins.blueprintI().employment() != null)
/* 112 */       ins.employees().prefferedSet((WGROUP.HTypeBits)this.pref); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\mai\\util\RoomState$RoomStateInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */