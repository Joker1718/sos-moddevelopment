/*     */ package settlement.room.main.employment;
/*     */ 
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Tree;
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
/*     */ class A_Target
/*     */   implements Employer.AA
/*     */ {
/*     */   private ArrayList<Employer.Bucket> samePrio;
/*     */   private final Tree<Employer.Bucket> sort;
/*     */   private int a;
/*     */   
/*     */   private A_Target() {
/* 130 */     this.samePrio = new ArrayList(paramEmployer.buckets.length);
/* 131 */     this.sort = new Tree<Employer.Bucket>(paramEmployer.buckets.length)
/*     */       {
/*     */         protected boolean isGreaterThan(Employer.Bucket current, Employer.Bucket cmp) {
/* 134 */           return (current.prio * (Employer.A_Target.access$0(Employer.A_Target.this)).buckets.length + current.e.index() > cmp.prio * (Employer.A_Target.access$0(Employer.A_Target.this)).buckets.length + cmp.e.index());
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean update() {
/* 143 */     if (!this.sort.hasMore()) {
/* 144 */       this.a = Employer.this.available.tot(); byte b; int i;
/*     */       Employer.Bucket[] arrayOfBucket;
/* 146 */       for (i = (arrayOfBucket = Employer.this.buckets).length, b = 0; b < i; ) { Employer.Bucket e = arrayOfBucket[b];
/* 147 */         e.clear();
/*     */         
/* 149 */         if (e.needed > 0) {
/* 150 */           this.sort.add(e);
/* 151 */           if (Employer.this.log)
/* 152 */             LOG.ln("TARGET adding: " + (e.e.blueprint()).key + " " + e.needed); 
/*     */         } 
/*     */         b++; }
/*     */       
/* 156 */       if (!this.sort.hasMore())
/* 157 */         return false; 
/* 158 */       return true;
/*     */     } 
/* 160 */     Employer.Bucket f = (Employer.Bucket)this.sort.pollGreatest();
/* 161 */     this.samePrio.clearSloppy();
/* 162 */     this.samePrio.add(f);
/* 163 */     while (this.sort.hasMore() && ((Employer.Bucket)this.sort.greatest()).e.priority.get() == f.e.priority.get()) {
/* 164 */       this.samePrio.add(this.sort.pollGreatest());
/*     */     }
/*     */     
/* 167 */     int needed = 0;
/* 168 */     for (Employer.Bucket e : this.samePrio) {
/* 169 */       needed += e.e.neededWorkers();
/*     */     }
/*     */     
/* 172 */     double d = this.a / needed;
/* 173 */     d = CLAMP.d(d, 0.0D, 1.0D);
/*     */     
/* 175 */     if (Employer.this.log) {
/* 176 */       LOG.ln("TARGET avaliable: " + this.a + "/" + needed + " " + d + " " + this.sort.hasMore());
/*     */     }
/*     */     
/* 179 */     for (Employer.Bucket e : this.samePrio) {
/* 180 */       int t = (int)Math.ceil(e.e.neededWorkers() * d);
/* 181 */       t = CLAMP.i(t, 0, this.a);
/* 182 */       this.a -= t;
/* 183 */       e.target = t;
/* 184 */       if (Employer.this.log && t > 0) {
/* 185 */         LOG.ln("TARGET " + (e.e.blueprint()).key + " " + t);
/*     */       }
/*     */     } 
/* 188 */     return this.sort.hasMore();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 193 */     this.sort.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\employment\Employer$A_Target.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */