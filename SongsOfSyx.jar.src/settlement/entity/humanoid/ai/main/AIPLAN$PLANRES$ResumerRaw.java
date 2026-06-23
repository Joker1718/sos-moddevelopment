/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ResumerRaw
/*     */   implements AIEventListeners.HEventListener
/*     */ {
/*     */   public final CharSequence name;
/*     */   final byte index;
/*     */   public final String className;
/*     */   
/*     */   public ResumerRaw(AIPLAN.PLANRES daddy, CharSequence verb) {
/* 193 */     this.name = verb;
/* 194 */     this.index = (byte)daddy.resumers.add(this);
/* 195 */     String cn = getClass().getName();
/* 196 */     String[] ss = cn.split("\\.");
/*     */     
/* 198 */     String match = ss[ss.length - 1]; byte b; int i; StackTraceElement[] arrayOfStackTraceElement;
/* 199 */     for (i = (arrayOfStackTraceElement = (new Throwable()).getStackTrace()).length, b = 0; b < i; ) { StackTraceElement e = arrayOfStackTraceElement[b];
/* 200 */       if (e.toString().contains("." + match))
/* 201 */         match = match + "_" + match; 
/*     */       b++; }
/*     */     
/* 204 */     this.className = match;
/*     */   }
/*     */   
/*     */   public ResumerRaw(AIPLAN.PLANRES daddy) {
/* 208 */     this(daddy, "");
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation resFailed(Humanoid a, AIManager d, HEvent event) {
/* 213 */     return null;
/*     */   }
/*     */   
/*     */   public final AISUB.AISubActivation set(Humanoid a, AIManager d) {
/* 217 */     d.planResumerByte = this.index;
/* 218 */     return setAction(a, d);
/*     */   }
/*     */   
/*     */   public final AISUB.AISubActivation trySet(Humanoid a, AIManager d) {
/* 222 */     byte old = d.planResumerByte;
/* 223 */     d.planResumerByte = this.index;
/* 224 */     AISUB.AISubActivation s = setAction(a, d);
/* 225 */     if (s != null)
/* 226 */       return s; 
/* 227 */     d.planResumerByte = old;
/* 228 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract AISUB.AISubActivation setAction(Humanoid paramHumanoid, AIManager paramAIManager);
/*     */ 
/*     */   
/*     */   protected abstract AISUB.AISubActivation res(Humanoid paramHumanoid, AIManager paramAIManager);
/*     */   
/*     */   public abstract boolean con(Humanoid paramHumanoid, AIManager paramAIManager);
/*     */   
/*     */   public abstract void can(Humanoid paramHumanoid, AIManager paramAIManager);
/*     */   
/*     */   protected void name(Humanoid a, AIManager d, Str string) {
/* 242 */     string.add(this.name);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 247 */     return d.plansub().event(a, d, e);
/*     */   }
/*     */ 
/*     */   
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 252 */     if (d.plansub() == null)
/* 253 */       System.err.println((d.plan()).key + " " + (d.plan()).key + " " + (d.plan()).className); 
/* 254 */     return d.plansub().poll(a, d, e);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIPLAN$PLANRES$ResumerRaw.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */