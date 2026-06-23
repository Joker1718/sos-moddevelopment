/*     */ package settlement.room.infra.stockpile;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.room.infra.logistics.MoveDic;
/*     */ import settlement.room.main.job.StorageCrate;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import util.keymap.MAPPED;
/*     */ import util.statistics.HistoryResource;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class StockpileTally
/*     */ {
/*  28 */   private final HistoryResource amountDay = new HistoryResource(32, (TIMECYCLE)TIME.days(), true)
/*     */     {
/*  30 */       private final INFO info = new INFO(
/*  31 */           MoveDic.¤¤Stored, MoveDic.¤¤Stored);
/*     */ 
/*     */       
/*     */       public INFO info() {
/*  35 */         return this.info;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  42 */   final ArrayListGrower<TallyData> datas = new ArrayListGrower();
/*  43 */   public final TallyData crates = new TallyData(MoveDic.¤¤crates);
/*  44 */   public final TallyData space = new TallyData(MoveDic.¤¤capacity);
/*  45 */   public final TallyData spaceReserved = new TallyData(MoveDic.¤¤capacityRes);
/*  46 */   public final TallyData amount = new TallyData(this, MoveDic.¤¤Stored)
/*     */     {
/*     */       void set(StockpileInstance ins, int ri, int am)
/*     */       {
/*  50 */         super.set(ins, ri, am);
/*  51 */         StockpileTally.this.amountDay.set((MAPPED)RESOURCES.ALL().get(ri), total(ri));
/*     */       }
/*     */     };
/*     */   
/*  55 */   public final TallyData amountReserved = new TallyData(MoveDic.¤¤StoredRes);
/*     */ 
/*     */   
/*  58 */   public final DOUBLE_O<RESOURCE> usage = new DOUBLE_O<RESOURCE>()
/*     */     {
/*     */       public double getD(RESOURCE t)
/*     */       {
/*  62 */         int sp = StockpileTally.this.space.total(t);
/*  63 */         if (sp == 0)
/*  64 */           return 1.0D; 
/*  65 */         double used = StockpileTally.this.amount.total(t);
/*  66 */         return used / sp;
/*     */       }
/*     */     };
/*     */   
/*  70 */   public final INT_O<RESOURCE> amountReservable = new INT_O<RESOURCE>()
/*     */     {
/*     */       public int get(RESOURCE res)
/*     */       {
/*  74 */         return StockpileTally.this.amount.total(res) - StockpileTally.this.amountReserved.total(res);
/*     */       }
/*     */ 
/*     */       
/*     */       public int min(RESOURCE t) {
/*  79 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public int max(RESOURCE t) {
/*  84 */         return Integer.MAX_VALUE;
/*     */       }
/*     */     };
/*     */   
/*     */   void clear() {
/*  89 */     for (TallyData d : this.datas) {
/*  90 */       d.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   final SAVABLE saver;
/*     */ 
/*     */   
/*     */   void init(StockpileInstance ins) {
/*  99 */     ins.tdata = Alloc.i2(this.datas.size(), RESOURCES.ALL().size() + 1);
/* 100 */     for (int i = 0; i < ins.crates.size(); i++) {
/* 101 */       ins.crates.set(i);
/* 102 */       StorageCrate cr = ins.crate(ins.crates.get().x(), ins.crates.get().y());
/* 103 */       report(cr, ins, 1);
/*     */     } 
/* 105 */     ins.updateMasks();
/*     */   }
/*     */ 
/*     */   
/*     */   void report(StorageCrate cr, StockpileInstance ins, int delta) {
/* 110 */     if (cr.resource() != null) {
/* 111 */       int ri = cr.resource().index();
/* 112 */       this.crates.inc(ins, ri, delta);
/* 113 */       this.space.inc(ins, ri, delta * ins.crateSize(cr.resource()));
/* 114 */       this.spaceReserved.inc(ins, ri, delta * cr.reservedSpace());
/* 115 */       this.amount.inc(ins, ri, delta * cr.amount());
/* 116 */       this.amountReserved.inc(ins, ri, delta * cr.reserved());
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
/*     */   public StockpileTally() {
/* 134 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/* 138 */           StockpileTally.this.amountDay.save(file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 143 */           StockpileTally.this.amountDay.load(file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/* 148 */           StockpileTally.this.amountDay.clear();
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public class TallyData
/*     */   {
/* 155 */     private final int[] ams = Alloc.ii(RESOURCES.ALL().size() + 1);
/* 156 */     private final RBIT.RBITImp bits = new RBIT.RBITImp();
/*     */     public final CharSequence name;
/*     */     private final int index;
/*     */     
/*     */     TallyData(CharSequence name) {
/* 161 */       this.name = name;
/* 162 */       this.index = StockpileTally.this.datas.add(this);
/*     */     }
/*     */     
/*     */     public int total(int ri) {
/* 166 */       return this.ams[ri];
/*     */     }
/*     */     
/*     */     public int total(RESOURCE res) {
/* 170 */       if (res == null)
/* 171 */         return this.ams[RESOURCES.ALL().size()]; 
/* 172 */       return this.ams[res.index()];
/*     */     }
/*     */     
/*     */     public int get(int ri, StockpileInstance ins) {
/* 176 */       return ins.tdata[this.index][ri];
/*     */     }
/*     */     
/*     */     public int get(RESOURCE res, StockpileInstance ins) {
/* 180 */       if (res == null)
/* 181 */         return ins.tdata[this.index][RESOURCES.ALL().size()]; 
/* 182 */       return ins.tdata[this.index][res.index()];
/*     */     }
/*     */     
/*     */     void inc(StockpileInstance ins, int ri, int am) {
/* 186 */       set(ins, ri, get(ri, ins) + am);
/*     */     }
/*     */     
/*     */     void set(StockpileInstance ins, int ri, int am) {
/* 190 */       int old = ins.tdata[this.index][ri];
/* 191 */       ins.tdata[this.index][RESOURCES.ALL().size()] = ins.tdata[this.index][RESOURCES.ALL().size()] - old;
/* 192 */       ins.tdata[this.index][ri] = am;
/* 193 */       ins.tdata[this.index][RESOURCES.ALL().size()] = ins.tdata[this.index][RESOURCES.ALL().size()] + am;
/*     */       
/* 195 */       this.ams[ri] = this.ams[ri] + am - old;
/* 196 */       this.ams[RESOURCES.ALL().size()] = this.ams[RESOURCES.ALL().size()] + am - old;
/*     */       
/* 198 */       if (this.ams[ri] < 0)
/* 199 */         throw new RuntimeException(String.valueOf(RESOURCES.ALL().get(ri)) + " " + String.valueOf(RESOURCES.ALL().get(ri))); 
/* 200 */       if (this.ams[ri] > 0) {
/* 201 */         this.bits.or((RESOURCE)RESOURCES.ALL().get(ri));
/*     */       } else {
/* 203 */         this.bits.clear((RESOURCE)RESOURCES.ALL().get(ri));
/*     */       } 
/*     */     }
/*     */     void clear() {
/* 207 */       Arrays.fill(this.ams, 0);
/* 208 */       this.bits.clear();
/*     */     }
/*     */     
/*     */     public RBIT bits() {
/* 212 */       return (RBIT)this.bits;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\stockpile\StockpileTally.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */