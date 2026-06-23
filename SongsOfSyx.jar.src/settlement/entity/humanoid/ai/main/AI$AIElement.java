/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
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
/*     */ public class AIElement
/*     */ {
/*     */   public final String className;
/*     */   final int index;
/*     */   public final String key;
/*     */   
/*     */   protected AIElement(String key) {
/* 163 */     String cn = getClass().getName();
/* 164 */     String[] ss = cn.split("\\.");
/*     */     
/* 166 */     String match = ss[ss.length - 1]; byte b; int i; StackTraceElement[] arrayOfStackTraceElement;
/* 167 */     for (i = (arrayOfStackTraceElement = (new Throwable()).getStackTrace()).length, b = 0; b < i; ) { StackTraceElement e = arrayOfStackTraceElement[b];
/* 168 */       if (e.toString().contains("." + match))
/* 169 */         match = match + "_" + match; 
/*     */       b++; }
/*     */     
/* 172 */     this.className = match;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 177 */     AI.s.map.put(key, this);
/* 178 */     this.index = AI.s.all.add(this);
/* 179 */     this.key = key;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getClassLine(Humanoid a, AIManager d) {
/* 184 */     String ss = getClass().toString();
/* 185 */     return ss;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AI$AIElement.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */