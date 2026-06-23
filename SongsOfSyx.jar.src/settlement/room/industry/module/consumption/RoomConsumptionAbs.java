/*     */ package settlement.room.industry.module.consumption;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Boostable;
/*     */ import game.faction.FResources;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.industry.module.IndustryRate;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.industry.module.RoomBoost;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.data.DataOSimple;
/*     */ import util.data.INT_O;
/*     */ import util.statistics.HistoryInt;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoomConsumptionAbs
/*     */   implements SAVABLE, IndustryRate
/*     */ {
/*  34 */   protected final ArrayListGrower<IndustryResource> allIns = new ArrayListGrower();
/*  35 */   protected final ArrayListGrower<IndustryResource> allRes = new ArrayListGrower();
/*  36 */   protected IndustryResourceIn[] inMap = new IndustryResourceIn[RESOURCES.ALL().size()];
/*     */   
/*     */   private final Boostable bonus;
/*  39 */   public final ArrayListGrower<RoomBoost> roomBoosts = new ArrayListGrower();
/*     */   public final RoomBlueprintImp blue;
/*     */   protected final INT_O.INT_OE<ROOM_IDATA_INSTANCE> pday;
/*  42 */   public Boostable conBonus = null;
/*     */   
/*  44 */   protected final DataOSimple<ROOM_IDATA_INSTANCE> data = new DataOSimple<ROOM_IDATA_INSTANCE>()
/*     */     {
/*     */       protected long[] data(ROOM_IDATA_INSTANCE t)
/*     */       {
/*  48 */         return t.productionData();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomConsumptionAbs(RoomBlueprintImp blue, Boostable bonus) {
/*  57 */     this.data.getClass(); this.pday = (INT_O.INT_OE<ROOM_IDATA_INSTANCE>)new DataOSimple.DataNibble(this.data);
/*     */     
/*  59 */     this.blue = blue;
/*  60 */     this.bonus = bonus;
/*     */   }
/*     */ 
/*     */   
/*     */   public IndustryResource in(RESOURCE res) {
/*  65 */     return this.inMap[res.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateRoom(ROOM_IDATA_INSTANCE r) {
/*  70 */     if (this.pday.get(r) != (TIME.days().bitCurrent() & 0xF)) {
/*  71 */       this.pday.set(r, TIME.days().bitCurrent() & 0xF);
/*  72 */       boolean year = (TIME.days().bitsSinceStart() % TIME.years().bitConversion((TIMECYCLE)TIME.days()) == 0.0D);
/*  73 */       for (IndustryResource i : this.allRes) {
/*  74 */         int v = (int)i.day.getD(r);
/*  75 */         i.dayPrev.set(r, v);
/*  76 */         i.day.incD(r, -v);
/*  77 */         if (year) {
/*  78 */           i.yearPrev.set(r, i.year.get(r));
/*  79 */           i.year.set(r, 0);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public LIST<IndustryResource> ins() {
/*  86 */     return (LIST<IndustryResource>)this.allIns;
/*     */   }
/*     */ 
/*     */   
/*     */   public Boostable bonus() {
/*  91 */     return this.bonus;
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<RoomBoost> boosts() {
/*  96 */     return (LIST<RoomBoost>)this.roomBoosts;
/*     */   }
/*     */   
/*     */   public long[] makeData() {
/* 100 */     return new long[this.data.longCount()];
/*     */   }
/*     */   
/*     */   public long[] makeDataFix(long[] old) {
/* 104 */     if (old.length != this.data.longCount())
/* 105 */       return new long[this.data.longCount()]; 
/* 106 */     return old;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 111 */     file.i(this.allRes.size());
/* 112 */     for (IndustryResource r : this.allRes) {
/* 113 */       r.save(file);
/*     */     }
/*     */   }
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 118 */     int am = file.i();
/* 119 */     if (am != this.allRes.size()) {
/* 120 */       HistoryInt history = new HistoryInt(48, (TIMECYCLE)TIME.days(), false);
/* 121 */       for (int i = 0; i < am; i++)
/* 122 */         history.load(file); 
/* 123 */       clear();
/*     */     } else {
/* 125 */       for (IndustryResource r : this.allRes) {
/* 126 */         r.load(file);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 133 */     for (IndustryResource r : this.allRes)
/* 134 */       r.clear(); 
/*     */   }
/*     */   
/*     */   protected final class IndustryResourceIn
/*     */     extends IndustryResource
/*     */   {
/*     */     public IndustryResourceIn(DataOSimple<ROOM_IDATA_INSTANCE> data, RESOURCE res, double rate, double AI, double AIRate) {
/* 141 */       super(data, RoomConsumptionAbs.this.allIns.size(), res, rate, AI, AIRate);
/* 142 */       RoomConsumptionAbs.this.allIns.add(this);
/* 143 */       RoomConsumptionAbs.this.inMap[this.resource.index()] = this;
/* 144 */       RoomConsumptionAbs.this.allRes.add(this);
/*     */     }
/*     */ 
/*     */     
/*     */     public int inc(ROOM_IDATA_INSTANCE r, double amount, boolean record) {
/* 149 */       int old = (int)this.day.getD(r);
/* 150 */       this.day.incD(r, amount);
/* 151 */       int now = (int)this.day.getD(r);
/* 152 */       int d = now - old;
/* 153 */       if (record)
/* 154 */         GAME.player().res().inc(this.resource, FResources.RTYPE.PRODUCED, -d); 
/* 155 */       this.year.inc(r, d);
/* 156 */       this.history.inc(d);
/* 157 */       return d;
/*     */     }
/*     */ 
/*     */     
/*     */     protected double getEffort(Humanoid skill, ROOM_IDATA_INSTANCE r, double workSeconds) {
/* 162 */       return IndustryUtil.calcConsumptionRate(this.rateSeconds * workSeconds, skill, (RoomInstance)r, RoomConsumptionAbs.this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public double consumptionRate(RoomInstance ins, Humanoid h, IndustryResource oo) {
/* 168 */     return ins.employees().totEfficiency() * IndustryUtil.calcConsumptionRate(oo.rate, h, ins, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double conBonus(BOOSTABLE_O bo) {
/* 177 */     if (this.conBonus == null)
/* 178 */       return 1.0D; 
/* 179 */     return this.conBonus.get(bo);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\consumption\RoomConsumptionAbs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */