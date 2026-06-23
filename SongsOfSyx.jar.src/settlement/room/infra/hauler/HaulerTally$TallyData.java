/*     */ package settlement.room.infra.hauler;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.Alloc;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TallyData
/*     */ {
/* 138 */   private final int[] ams = Alloc.ii(RESOURCES.ALL().size() + 1);
/* 139 */   private final RBIT.RBITImp bits = new RBIT.RBITImp();
/*     */   public final CharSequence name;
/*     */   private final int index;
/*     */   
/*     */   TallyData(CharSequence name) {
/* 144 */     this.name = name;
/* 145 */     this.index = paramHaulerTally.datas.add(this);
/*     */   }
/*     */   
/*     */   public int total(int ri) {
/* 149 */     return this.ams[ri];
/*     */   }
/*     */   
/*     */   public int total(RESOURCE res) {
/* 153 */     if (res == null)
/* 154 */       return this.ams[RESOURCES.ALL().size()]; 
/* 155 */     return this.ams[res.index()];
/*     */   }
/*     */   
/*     */   public int get(HaulerInstance ins) {
/* 159 */     return ins.tdata[this.index];
/*     */   }
/*     */   
/*     */   void inc(HaulerInstance ins, int am) {
/* 163 */     set(ins, get(ins) + am);
/*     */   }
/*     */ 
/*     */   
/*     */   void set(HaulerInstance ins, int am) {
/* 168 */     int old = ins.tdata[this.index];
/* 169 */     ins.tdata[this.index] = am;
/* 170 */     if (ins.resource() == null)
/*     */       return; 
/* 172 */     int ri = ins.resource().index();
/* 173 */     this.ams[ri] = this.ams[ri] + am - old;
/* 174 */     this.ams[RESOURCES.ALL().size()] = this.ams[RESOURCES.ALL().size()] + am - old;
/*     */     
/* 176 */     if (this.ams[ri] < 0)
/* 177 */       throw new RuntimeException(String.valueOf(RESOURCES.ALL().get(ri)) + " " + String.valueOf(RESOURCES.ALL().get(ri))); 
/* 178 */     if (this.ams[ri] > 0) {
/* 179 */       this.bits.or((RESOURCE)RESOURCES.ALL().get(ri));
/*     */     } else {
/* 181 */       this.bits.clear((RESOURCE)RESOURCES.ALL().get(ri));
/*     */     } 
/*     */   }
/*     */   void clear() {
/* 185 */     Arrays.fill(this.ams, 0);
/* 186 */     this.bits.clear();
/*     */   }
/*     */   
/*     */   public RBIT bits() {
/* 190 */     return (RBIT)this.bits;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\hauler\HaulerTally$TallyData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */