/*     */ package settlement.room.military.supply;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.util.Arrays;
/*     */ import settlement.room.infra.logistics.MoveDic;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import util.text.Dic;
/*     */ import world.army.AD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SupplyTally
/*     */ {
/*  19 */   final ArrayListGrower<TallyData> datas = new ArrayListGrower();
/*  20 */   private int unusedCrate = 0;
/*  21 */   public final TallyData crates = new TallyData(MoveDic.¤¤crates);
/*  22 */   public final TallyData spaceReserved = new TallyData(Dic.¤¤Inbound);
/*  23 */   public final TallyData amount = new TallyData(MoveDic.¤¤Stored);
/*     */ 
/*     */ 
/*     */   
/*     */   private final ROOM_SUPPLY b;
/*     */ 
/*     */   
/*     */   private final RBIT.RBITImp tmp;
/*     */ 
/*     */ 
/*     */   
/*     */   void clear() {
/*  35 */     for (TallyData d : this.datas)
/*  36 */       d.clear(); 
/*     */   }
/*     */   
/*     */   void init(SupplyInstance ins) {
/*  40 */     ins.tdata = new short[this.datas.size() * (RESOURCES.ALL().size() + 1) + 1];
/*  41 */     for (int ji = 0; ji < ins.jobs.size(); ji++) {
/*  42 */       COORDINATE c = ins.jobs.get(ji);
/*  43 */       if (ins.is(c)) {
/*  44 */         Crate cr = this.b.crate.get(c.x(), c.y());
/*  45 */         if (cr != null)
/*  46 */           report(cr, ins, 1); 
/*     */       } 
/*     */     } 
/*  49 */     ins.reset();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void report(Crate crate, SupplyInstance ins, int delta) {
/*  56 */     if (crate.storage() != null) {
/*  57 */       RESOURCE a = crate.realResource();
/*  58 */       if (a != null) {
/*  59 */         this.crates.inc(ins, a, delta);
/*  60 */         this.spaceReserved.inc(ins, a, delta * crate.storage().storageReserved());
/*  61 */         this.amount.inc(ins, a, delta * crate.resAmount());
/*     */       } else {
/*  63 */         ins.tdata[this.datas.size() * (RESOURCES.ALL().size() + 1)] = (short)(ins.tdata[this.datas.size() * (RESOURCES.ALL().size() + 1)] + delta);
/*  64 */         this.unusedCrate += delta;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int amountTotal(RESOURCE res) {
/*  73 */     return this.amount.total(res);
/*     */   }
/*     */   
/*     */   public int unusedCrates() {
/*  77 */     return this.unusedCrate;
/*     */   }
/*     */   
/*     */   public int unusedCrates(SupplyInstance ins) {
/*  81 */     return ins.tdata[this.datas.size() * (RESOURCES.ALL().size() + 1)];
/*     */   }
/*     */   
/*     */   public class TallyData
/*     */   {
/*     */     private final int insStride;
/*  87 */     private final int[] ams = Alloc.ii(RESOURCES.ALL().size() + 1);
/*     */     public final CharSequence name;
/*     */     private final int index;
/*     */     
/*     */     TallyData(CharSequence name) {
/*  92 */       this.name = name;
/*  93 */       this.index = SupplyTally.this.datas.add(this);
/*  94 */       this.insStride = this.index * (RESOURCES.ALL().size() + 1);
/*     */     }
/*     */     
/*     */     public int total(RESOURCE a) {
/*  98 */       if (a == null)
/*  99 */         return this.ams[RESOURCES.ALL().size()]; 
/* 100 */       return this.ams[a.index()];
/*     */     }
/*     */     
/*     */     public int get(SupplyInstance ins, RESOURCE a) {
/* 104 */       if (a == null)
/* 105 */         return ins.tdata[this.insStride + RESOURCES.ALL().size()]; 
/* 106 */       return ins.tdata[this.insStride + a.index()];
/*     */     }
/*     */     
/*     */     private void inc(SupplyInstance ins, RESOURCE a, int am) {
/* 110 */       set(ins, a, get(ins, a) + am);
/*     */     }
/*     */     
/*     */     private void set(SupplyInstance ins, RESOURCE a, int am) {
/* 114 */       int old = ins.tdata[this.insStride + a.index()];
/* 115 */       this.ams[a.index()] = this.ams[a.index()] - old;
/* 116 */       this.ams[RESOURCES.ALL().size()] = this.ams[RESOURCES.ALL().size()] - old;
/* 117 */       ins.tdata[this.insStride + a.index()] = (short)am;
/* 118 */       ins.tdata[this.insStride + RESOURCES.ALL().size()] = (short)am;
/* 119 */       this.ams[a.index()] = this.ams[a.index()] + am;
/* 120 */       this.ams[RESOURCES.ALL().size()] = this.ams[RESOURCES.ALL().size()] - am;
/*     */       
/* 122 */       if (this.ams[a.index()] < 0)
/* 123 */         throw new RuntimeException(String.valueOf(a) + " " + String.valueOf(a)); 
/*     */     }
/*     */     
/*     */     private void clear() {
/* 127 */       Arrays.fill(this.ams, 0);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   RESOURCE getNewCrate(int ai, RBIT allowed) {
/* 134 */     for (int i = 0; i < AD.supplies().resses().size(); i++) {
/* 135 */       ai %= AD.supplies().resses().size();
/* 136 */       RESOURCE res = (RESOURCE)AD.supplies().resses().get(ai);
/* 137 */       if (allowed.has(res)) {
/* 138 */         int am = this.b.cache.needed(res);
/*     */ 
/*     */         
/* 141 */         if (this.crates.total(res) * 80 < am)
/* 142 */           return res; 
/*     */       } 
/* 144 */       ai++;
/*     */     } 
/*     */ 
/*     */     
/* 148 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   int fetchAmount(RESOURCE a) {
/* 154 */     if (a == null) {
/* 155 */       return 0;
/*     */     }
/* 157 */     int am = this.b.cache.needed(a);
/* 158 */     am -= this.spaceReserved.total(a);
/* 159 */     am -= this.amount.total(a);
/* 160 */     return am;
/*     */   }
/*     */   
/*     */   public SupplyTally(ROOM_SUPPLY b) {
/* 164 */     this.tmp = new RBIT.RBITImp();
/*     */     this.b = b;
/*     */   }
/*     */   RBIT fetchBit(SupplyInstance ins, RBIT allowed) {
/* 168 */     this.tmp.clear();
/*     */     
/* 170 */     for (RESOURCE res : AD.supplies().resses()) {
/* 171 */       if (!allowed.has(res)) {
/*     */         continue;
/*     */       }
/* 174 */       if (capacity(ins, res) > 0) {
/* 175 */         int am = this.b.cache.needed(res);
/* 176 */         am -= this.spaceReserved.total(res);
/* 177 */         am -= this.amount.total(res);
/* 178 */         if (am > 0)
/* 179 */           this.tmp.or(res);  continue;
/*     */       } 
/* 181 */       if (otherCapacity(ins, res) > 0) {
/* 182 */         int am = this.b.cache.needed(res);
/* 183 */         am -= this.crates.total(res) * 80;
/* 184 */         if (am > 0) {
/* 185 */           this.tmp.or(res);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 190 */     return (RBIT)this.tmp;
/*     */   }
/*     */ 
/*     */   
/*     */   private int capacity(SupplyInstance ins, RESOURCE res) {
/* 195 */     return this.crates.get(ins, res) * 80 - this.spaceReserved.get(ins, res) - this.amount.get(ins, res);
/*     */   }
/*     */   
/*     */   int otherCapacity(SupplyInstance ins, RESOURCE res) {
/* 199 */     return unusedCrates(ins) * 80;
/*     */   }
/*     */   
/*     */   int capacity(SupplyInstance ins, RESOURCE res, RBIT allowed) {
/* 203 */     if (!allowed.has(res))
/* 204 */       return 0; 
/* 205 */     return capacity(ins, res) + otherCapacity(ins, res);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\supply\SupplyTally.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */