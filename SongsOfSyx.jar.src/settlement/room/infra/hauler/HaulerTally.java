/*     */ package settlement.room.infra.hauler;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.util.Arrays;
/*     */ import settlement.room.infra.logistics.MoveDic;
/*     */ import settlement.room.main.job.StorageCrate;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import util.keymap.MAPPED;
/*     */ import util.statistics.HistoryResource;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class HaulerTally
/*     */ {
/*  24 */   private final HistoryResource amounts = new HistoryResource(64, (TIMECYCLE)TIME.seasons(), true)
/*     */     {
/*  26 */       private final INFO info = new INFO(
/*  27 */           MoveDic.¤¤Stored, MoveDic.¤¤StoredD);
/*     */ 
/*     */       
/*     */       public INFO info() {
/*  31 */         return this.info;
/*     */       }
/*     */     };
/*  34 */   private final HistoryResource amountDay = new HistoryResource(32, (TIMECYCLE)TIME.days(), true)
/*     */     {
/*     */       public INFO info()
/*     */       {
/*  38 */         return HaulerTally.this.amounts.info();
/*     */       }
/*     */     };
/*     */   
/*  42 */   final ArrayListGrower<TallyData> datas = new ArrayListGrower();
/*  43 */   public final TallyData crates = new TallyData(MoveDic.¤¤crates);
/*  44 */   public final TallyData space = new TallyData(MoveDic.¤¤capacity);
/*  45 */   public final TallyData spaceReserved = new TallyData(MoveDic.¤¤capacityRes);
/*  46 */   public final TallyData amount = new TallyData(this, MoveDic.¤¤Stored)
/*     */     {
/*     */       void set(HaulerInstance ins, int am)
/*     */       {
/*  50 */         super.set(ins, am);
/*  51 */         if (ins.resource() != null)
/*  52 */           HaulerTally.this.amountDay.set((MAPPED)ins.resource(), total(ins.resource())); 
/*     */       }
/*     */     };
/*     */   
/*  56 */   public final TallyData amountReserved = new TallyData(MoveDic.¤¤StoredRes);
/*     */ 
/*     */   
/*  59 */   public final DOUBLE_O<RESOURCE> usage = new DOUBLE_O<RESOURCE>()
/*     */     {
/*     */       public double getD(RESOURCE t)
/*     */       {
/*  63 */         int sp = HaulerTally.this.space.total(t);
/*  64 */         if (sp == 0)
/*  65 */           return 1.0D; 
/*  66 */         double used = HaulerTally.this.amount.total(t);
/*  67 */         return used / sp;
/*     */       }
/*     */     };
/*     */   
/*  71 */   public final INT_O<RESOURCE> amountReservable = new INT_O<RESOURCE>()
/*     */     {
/*     */       public int get(RESOURCE res)
/*     */       {
/*  75 */         return HaulerTally.this.amount.total(res) - HaulerTally.this.amountReserved.total(res);
/*     */       }
/*     */ 
/*     */       
/*     */       public int min(RESOURCE t) {
/*  80 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public int max(RESOURCE t) {
/*  85 */         return Integer.MAX_VALUE;
/*     */       }
/*     */     };
/*     */   
/*     */   void clear() {
/*  90 */     for (TallyData d : this.datas) {
/*  91 */       d.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void init(HaulerInstance ins) {
/* 100 */     ins.tdata = Alloc.ii(this.datas.size());
/* 101 */     for (COORDINATE c : ins.body()) {
/* 102 */       StorageCrate cr = ins.storage(c.x(), c.y());
/* 103 */       if (cr != null)
/* 104 */         report(cr, ins, 1); 
/*     */     } 
/* 106 */     ins.updateMasks();
/*     */   }
/*     */ 
/*     */   
/*     */   void report(StorageCrate cr, HaulerInstance ins, int delta) {
/* 111 */     if (cr.resource() != null) {
/* 112 */       this.crates.inc(ins, delta);
/* 113 */       this.space.inc(ins, delta * 80);
/* 114 */       this.spaceReserved.inc(ins, delta * cr.reservedSpace());
/* 115 */       this.amount.inc(ins, delta * cr.amount());
/* 116 */       this.amountReserved.inc(ins, delta * cr.reserved());
/*     */     } 
/*     */   }
/*     */   
/*     */   public HistoryResource amountsDay() {
/* 121 */     return this.amountDay;
/*     */   }
/*     */   
/*     */   public double load(RESOURCE res) {
/* 125 */     if (this.space.total(res) == 0)
/* 126 */       return 1.0D; 
/* 127 */     return this.amount.total(res) / this.space.total(res);
/*     */   }
/*     */   
/*     */   public int amountTotal(RESOURCE res) {
/* 131 */     return this.amount.total(res);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public class TallyData
/*     */   {
/* 138 */     private final int[] ams = Alloc.ii(RESOURCES.ALL().size() + 1);
/* 139 */     private final RBIT.RBITImp bits = new RBIT.RBITImp();
/*     */     public final CharSequence name;
/*     */     private final int index;
/*     */     
/*     */     TallyData(CharSequence name) {
/* 144 */       this.name = name;
/* 145 */       this.index = HaulerTally.this.datas.add(this);
/*     */     }
/*     */     
/*     */     public int total(int ri) {
/* 149 */       return this.ams[ri];
/*     */     }
/*     */     
/*     */     public int total(RESOURCE res) {
/* 153 */       if (res == null)
/* 154 */         return this.ams[RESOURCES.ALL().size()]; 
/* 155 */       return this.ams[res.index()];
/*     */     }
/*     */     
/*     */     public int get(HaulerInstance ins) {
/* 159 */       return ins.tdata[this.index];
/*     */     }
/*     */     
/*     */     void inc(HaulerInstance ins, int am) {
/* 163 */       set(ins, get(ins) + am);
/*     */     }
/*     */ 
/*     */     
/*     */     void set(HaulerInstance ins, int am) {
/* 168 */       int old = ins.tdata[this.index];
/* 169 */       ins.tdata[this.index] = am;
/* 170 */       if (ins.resource() == null)
/*     */         return; 
/* 172 */       int ri = ins.resource().index();
/* 173 */       this.ams[ri] = this.ams[ri] + am - old;
/* 174 */       this.ams[RESOURCES.ALL().size()] = this.ams[RESOURCES.ALL().size()] + am - old;
/*     */       
/* 176 */       if (this.ams[ri] < 0)
/* 177 */         throw new RuntimeException(String.valueOf(RESOURCES.ALL().get(ri)) + " " + String.valueOf(RESOURCES.ALL().get(ri))); 
/* 178 */       if (this.ams[ri] > 0) {
/* 179 */         this.bits.or((RESOURCE)RESOURCES.ALL().get(ri));
/*     */       } else {
/* 181 */         this.bits.clear((RESOURCE)RESOURCES.ALL().get(ri));
/*     */       } 
/*     */     }
/*     */     void clear() {
/* 185 */       Arrays.fill(this.ams, 0);
/* 186 */       this.bits.clear();
/*     */     }
/*     */     
/*     */     public RBIT bits() {
/* 190 */       return (RBIT)this.bits;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\hauler\HaulerTally.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */