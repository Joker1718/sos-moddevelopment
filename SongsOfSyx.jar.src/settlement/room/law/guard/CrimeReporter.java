/*     */ package settlement.room.law.guard;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.room.law.execution.ExecutionStation;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ public class CrimeReporter
/*     */ {
/*  19 */   private static int EE = 5;
/*     */   
/*     */   private int[] data;
/*  22 */   private static int tCrime = 0;
/*  23 */   private static int tExecution = 1;
/*     */   
/*     */   private final ROOM_GUARD b;
/*     */   
/*     */   CrimeReporter(ROOM_GUARD b) {
/*  28 */     this.b = b;
/*  29 */     this.data = Alloc.ii(512);
/*     */   }
/*     */   
/*     */   void save(FilePutter file) {
/*  33 */     file.isE(this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   void load(FileGetter file) throws IOException {
/*  38 */     file.isE(this.data);
/*     */   }
/*     */   
/*     */   void clear() {
/*  42 */     Arrays.fill(this.data, 0);
/*     */   }
/*     */   
/*     */   int[] makeData() {
/*  46 */     return Alloc.ii(EE * 2 + 2);
/*     */   }
/*     */   
/*     */   int[] data(GuardInstance ins) {
/*  50 */     if (ins.cdata == null || ins.cdata.length != EE * 2 + 2)
/*  51 */       ins.cdata = Alloc.ii(EE * 2 + 2); 
/*  52 */     return ins.cdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public void reportCriminal(Humanoid a) {
/*  57 */     if (RND.rBoolean())
/*     */       return; 
/*  59 */     report(tCrime, a.tc().x(), a.tc().y(), 90, a.id());
/*     */   }
/*     */   
/*     */   public void reportExecution(int tx, int ty) {
/*  63 */     int payload = tx << 16 & 0xFFFF0000 | ty & 0xFFFF;
/*  64 */     report(tExecution, tx, ty, 180, payload);
/*     */   }
/*     */   
/*     */   public int crimes(GuardInstance ins) {
/*  68 */     if (ins != null)
/*  69 */       return data(ins)[tCrime]; 
/*  70 */     return this.data[tCrime];
/*     */   }
/*     */   
/*     */   public int executions(GuardInstance ins) {
/*  74 */     if (ins != null)
/*  75 */       return data(ins)[tExecution]; 
/*  76 */     return this.data[tExecution];
/*     */   }
/*     */ 
/*     */   
/*     */   private void report(int type, int sx, int sy, int radius, int payload) {
/*  81 */     COORDINATE c = this.b.finder.reserve(sx, sy, radius);
/*     */     
/*  83 */     if (c != null) {
/*  84 */       GuardInstance ins = (GuardInstance)this.b.getter.get(c);
/*  85 */       int[] data = data(ins);
/*     */       
/*  87 */       boolean av = available(data);
/*  88 */       push(type, payload, data);
/*     */       
/*  90 */       if (av && !available(data))
/*  91 */         this.b.finder.report((FINDABLE)this.b.service.get(ins), -1); 
/*  92 */     } else if (RND.oneIn(4)) {
/*  93 */       push(type, payload, this.data);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean push(int stride, int payload, int[] data) {
/*  99 */     int length = (data.length - 2) / 2;
/* 100 */     int count = data[stride];
/* 101 */     if (count >= length)
/* 102 */       return false; 
/* 103 */     data[2 + length * stride + count] = payload;
/* 104 */     data[stride] = data[stride] + 1;
/* 105 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Humanoid pollCriminal(GuardInstance ins) {
/* 110 */     if (ins != null) {
/*     */       
/* 112 */       boolean av = available(this.data);
/*     */ 
/*     */       
/* 115 */       int i = pop(tCrime, data(ins));
/* 116 */       if (!av && available(this.data))
/* 117 */         this.b.finder.report((FINDABLE)this.b.service.get(ins), 1); 
/* 118 */       while (i >= 0) {
/* 119 */         ENTITY e = SETT.ENTITIES().getByID(i);
/* 120 */         if (e != null && e instanceof Humanoid && !e.isRemoved()) {
/* 121 */           Humanoid a = (Humanoid)e;
/* 122 */           if (AI.modules().isCriminal(a))
/* 123 */             return a; 
/*     */         } 
/* 125 */         i = pop(tCrime, ins.cdata);
/*     */       } 
/*     */     } 
/*     */     
/* 129 */     int id = pop(tCrime, this.data);
/* 130 */     while (id >= 0) {
/* 131 */       ENTITY e = SETT.ENTITIES().getByID(id);
/* 132 */       if (e != null && e instanceof Humanoid && !e.isRemoved()) {
/* 133 */         Humanoid a = (Humanoid)e;
/* 134 */         if (AI.modules().isCriminal(a))
/* 135 */           return a; 
/*     */       } 
/* 137 */       id = pop(tCrime, this.data);
/*     */     } 
/* 139 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ExecutionStation.Guard pollExecution(GuardInstance ins) {
/* 144 */     if (ins != null) {
/*     */       
/* 146 */       boolean av = available(this.data);
/*     */ 
/*     */       
/* 149 */       int i = pop(tExecution, data(ins));
/* 150 */       if (!av && available(this.data))
/* 151 */         this.b.finder.report((FINDABLE)this.b.service.get(ins), 1); 
/* 152 */       while (i >= 0) {
/* 153 */         int tx = i >> 16 & 0xFFFF;
/* 154 */         int ty = i & 0xFFFF;
/*     */         
/* 156 */         ExecutionStation.Guard g = (SETT.ROOMS()).EXECUTION.stations.guard(tx, ty);
/* 157 */         if (g != null && g.active())
/* 158 */           return g; 
/* 159 */         i = pop(tCrime, ins.cdata);
/*     */       } 
/*     */     } 
/*     */     
/* 163 */     int id = pop(tExecution, this.data);
/* 164 */     while (id >= 0) {
/* 165 */       int tx = id >> 16 & 0xFF;
/* 166 */       int ty = id & 0xFF;
/*     */       
/* 168 */       ExecutionStation.Guard g = (SETT.ROOMS()).EXECUTION.stations.guard(tx, ty);
/* 169 */       if (g != null && g.active())
/* 170 */         return g; 
/* 171 */       id = pop(tCrime, this.data);
/*     */     } 
/* 173 */     return null;
/*     */   }
/*     */   
/*     */   public boolean available(GuardInstance ins) {
/* 177 */     return available(data(ins));
/*     */   }
/*     */   
/*     */   private boolean available(int[] data) {
/* 181 */     int length = (data.length - 2) / 2;
/* 182 */     if (data[tCrime] >= length || data[tExecution] >= length)
/* 183 */       return false; 
/* 184 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int pop(int stride, int[] data) {
/* 190 */     int length = (data.length - 2) / 2;
/* 191 */     int count = data[stride];
/* 192 */     if (count == 0)
/* 193 */       return -1; 
/* 194 */     data[stride] = data[stride] - 1;
/* 195 */     return data[2 + length * stride + count - 1];
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\guard\CrimeReporter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */