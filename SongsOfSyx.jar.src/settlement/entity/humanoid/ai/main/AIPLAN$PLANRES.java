/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import game.GAME;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import snake2d.util.sets.ArrayListResize;
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
/*     */ public abstract class PLANRES
/*     */   extends AIPLAN
/*     */ {
/*  85 */   final ArrayListResize<ResumerRaw> resumers = new ArrayListResize(10, 100);
/*     */   
/*  87 */   protected final Resumer WAIT_AND_EXIT = new Resumer(this, "waiting")
/*     */     {
/*     */       protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */       {
/*  91 */         return (AI.SUBS()).STAND.activate(a, d);
/*     */       }
/*     */ 
/*     */       
/*     */       protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  96 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean con(Humanoid a, AIManager d) {
/* 101 */         return true;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void can(Humanoid a, AIManager d) {}
/*     */     };
/*     */ 
/*     */   
/*     */   public PLANRES(String key) {
/* 111 */     super(key);
/*     */   }
/*     */ 
/*     */   
/*     */   public AIPLAN.AiPlanActivation activate(Humanoid a, AIManager d) {
/* 116 */     d.planResumerByte = -1;
/* 117 */     AISUB.AISubActivation ac = init(a, d);
/*     */     
/* 119 */     if (ac != null) {
/* 120 */       AIPLAN.activation.plan = this;
/* 121 */       AIPLAN.activation.sub = ac;
/* 122 */       if (d.planResumerByte < 0)
/* 123 */         GAME.Error(String.valueOf(getClass())); 
/* 124 */       return AIPLAN.activation;
/*     */     } 
/* 126 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void cancel(Humanoid a, AIManager d) {
/* 131 */     if (this.resumers.size() <= d.planResumerByte)
/* 132 */       System.err.println(this.key + this.key); 
/* 133 */     ((ResumerRaw)this.resumers.get(d.planResumerByte)).can(a, d);
/* 134 */     d.planResumerByte = -5;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation resume(Humanoid a, AIManager d) {
/* 139 */     return ((ResumerRaw)this.resumers.get(d.planResumerByte)).res(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean shouldContinue(Humanoid a, AIManager d) {
/* 144 */     return ((ResumerRaw)this.resumers.get(d.planResumerByte)).con(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void name(Humanoid a, AIManager d, Str string) {
/* 149 */     ((ResumerRaw)this.resumers.get(d.planResumerByte)).name(a, d, string);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation resumeFailed(Humanoid a, AIManager d, HEvent event) {
/* 154 */     return ((ResumerRaw)this.resumers.get(d.planResumerByte)).resFailed(a, d, event);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String debug(Humanoid a, AIManager d) {
/* 159 */     if (d.planResumerByte < 0) {
/* 160 */       return AIPLAN.empty;
/*     */     }
/* 162 */     return getClass().getSimpleName() + " " + getClass().getSimpleName() + " " + d.planResumerByte + " " + String.valueOf(((ResumerRaw)this.resumers.get(d.planResumerByte)).name);
/*     */   }
/*     */   
/*     */   protected final ResumerRaw getResumer(AIManager d) {
/* 166 */     if (d.planResumerByte < 0 || d.planResumerByte >= this.resumers.size())
/* 167 */       return null; 
/* 168 */     return (ResumerRaw)this.resumers.get(d.planResumerByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 173 */     return ((ResumerRaw)this.resumers.get(d.planResumerByte)).event(a, d, e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 179 */     if (this.resumers.size() <= d.planResumerByte)
/* 180 */       System.err.println(this); 
/* 181 */     return ((ResumerRaw)this.resumers.get(d.planResumerByte)).poll(a, d, e);
/*     */   }
/*     */   
/*     */   protected abstract AISUB.AISubActivation init(Humanoid paramHumanoid, AIManager paramAIManager);
/*     */   
/*     */   public static abstract class ResumerRaw
/*     */     implements AIEventListeners.HEventListener {
/*     */     public final CharSequence name;
/*     */     final byte index;
/*     */     public final String className;
/*     */     
/*     */     public ResumerRaw(AIPLAN.PLANRES daddy, CharSequence verb) {
/* 193 */       this.name = verb;
/* 194 */       this.index = (byte)daddy.resumers.add(this);
/* 195 */       String cn = getClass().getName();
/* 196 */       String[] ss = cn.split("\\.");
/*     */       
/* 198 */       String match = ss[ss.length - 1]; byte b; int i; StackTraceElement[] arrayOfStackTraceElement;
/* 199 */       for (i = (arrayOfStackTraceElement = (new Throwable()).getStackTrace()).length, b = 0; b < i; ) { StackTraceElement e = arrayOfStackTraceElement[b];
/* 200 */         if (e.toString().contains("." + match))
/* 201 */           match = match + "_" + match; 
/*     */         b++; }
/*     */       
/* 204 */       this.className = match;
/*     */     }
/*     */     
/*     */     public ResumerRaw(AIPLAN.PLANRES daddy) {
/* 208 */       this(daddy, "");
/*     */     }
/*     */ 
/*     */     
/*     */     public AISUB.AISubActivation resFailed(Humanoid a, AIManager d, HEvent event) {
/* 213 */       return null;
/*     */     }
/*     */     
/*     */     public final AISUB.AISubActivation set(Humanoid a, AIManager d) {
/* 217 */       d.planResumerByte = this.index;
/* 218 */       return setAction(a, d);
/*     */     }
/*     */     
/*     */     public final AISUB.AISubActivation trySet(Humanoid a, AIManager d) {
/* 222 */       byte old = d.planResumerByte;
/* 223 */       d.planResumerByte = this.index;
/* 224 */       AISUB.AISubActivation s = setAction(a, d);
/* 225 */       if (s != null)
/* 226 */         return s; 
/* 227 */       d.planResumerByte = old;
/* 228 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     protected abstract AISUB.AISubActivation setAction(Humanoid param2Humanoid, AIManager param2AIManager);
/*     */ 
/*     */     
/*     */     protected abstract AISUB.AISubActivation res(Humanoid param2Humanoid, AIManager param2AIManager);
/*     */     
/*     */     public abstract boolean con(Humanoid param2Humanoid, AIManager param2AIManager);
/*     */     
/*     */     public abstract void can(Humanoid param2Humanoid, AIManager param2AIManager);
/*     */     
/*     */     protected void name(Humanoid a, AIManager d, Str string) {
/* 242 */       string.add(this.name);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 247 */       return d.plansub().event(a, d, e);
/*     */     }
/*     */ 
/*     */     
/*     */     public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 252 */       if (d.plansub() == null)
/* 253 */         System.err.println((d.plan()).key + " " + (d.plan()).key + " " + (d.plan()).className); 
/* 254 */       return d.plansub().poll(a, d, e);
/*     */     }
/*     */   }
/*     */   
/*     */   public abstract class Resumer
/*     */     extends ResumerRaw {
/*     */     public Resumer(CharSequence verb) {
/* 261 */       super(verb);
/*     */     }
/*     */     
/*     */     public Resumer() {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIPLAN$PLANRES.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */