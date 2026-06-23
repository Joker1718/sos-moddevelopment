/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LISTE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Resumable
/*     */   extends AISUB
/*     */   implements AIEventListeners.HEventListener
/*     */ {
/*     */   private final CharSequence name;
/* 168 */   private final LISTE<Resumer> all = (LISTE<Resumer>)new ArrayList(20);
/*     */   
/*     */   protected Resumable(String key, CharSequence name) {
/* 171 */     super(key);
/* 172 */     this.name = name;
/*     */   }
/*     */   
/*     */   protected Resumable(String key) {
/* 176 */     super(key);
/* 177 */     this.name = getClass().getSimpleName();
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISTATE resumeInterrupted(Humanoid a, AIManager d, HEvent event) {
/* 182 */     return ((Resumer)this.all.get(d.subByte)).resI(a, d, event);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final AISUB.AISubActivation activate(Humanoid a, AIManager d) {
/* 189 */     d.subByte = -1;
/* 190 */     return AISUB.AISubActivation.make(this, resume(a, d));
/*     */   }
/*     */   
/*     */   protected final AISUB.AISubActivation activate(Humanoid a, AIManager d, Resumer res) {
/* 194 */     d.subByte = res.index;
/* 195 */     return AISUB.AISubActivation.make(this, res.set(a, d));
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract AISTATE init(Humanoid paramHumanoid, AIManager paramAIManager);
/*     */   
/*     */   protected AISTATE resume(Humanoid a, AIManager d) {
/* 202 */     if (d.subByte == -1)
/* 203 */       return init(a, d); 
/* 204 */     return ((Resumer)this.all.get(d.subByte)).res(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isSuccessful(Humanoid a, AIManager d) {
/* 209 */     if (d.subByte == -1)
/* 210 */       return true; 
/* 211 */     return ((Resumer)this.all.get(d.subByte)).success(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void cancel(Humanoid a, AIManager d) {
/* 216 */     if (d.subByte == -1)
/*     */       return; 
/* 218 */     ((Resumer)this.all.get(d.subByte)).can(a, d);
/*     */   }
/*     */   
/*     */   protected Resumer getResumer(Humanoid a, AIManager d) {
/* 222 */     if (d.subByte < 0)
/* 223 */       return null; 
/* 224 */     return (Resumer)this.all.get(d.subByte);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected CharSequence name(Humanoid a, AIManager d) {
/* 230 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 235 */     return ((Resumer)this.all.get(d.subByte)).event(a, d, e);
/*     */   }
/*     */ 
/*     */   
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 240 */     return ((Resumer)this.all.get(d.subByte)).poll(a, d, e);
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract class Resumer
/*     */     implements AIEventListeners.Default
/*     */   {
/* 247 */     protected final byte index = (byte)AISUB.Resumable.this.all.add(this);
/*     */ 
/*     */     
/*     */     public final AISTATE set(Humanoid a, AIManager d) {
/* 251 */       d.subByte = this.index;
/* 252 */       return setAction(a, d);
/*     */     }
/*     */     protected abstract AISTATE setAction(Humanoid param2Humanoid, AIManager param2AIManager);
/*     */     protected abstract AISTATE res(Humanoid param2Humanoid, AIManager param2AIManager);
/*     */     
/*     */     protected AISTATE resI(Humanoid a, AIManager d, HEvent event) {
/* 258 */       return null;
/*     */     }
/*     */     protected boolean success(Humanoid a, AIManager d) {
/* 261 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void can(Humanoid a, AIManager d) {}
/*     */   }
/*     */   
/*     */   final Resumer get(Humanoid a, AIManager d) {
/* 269 */     return (Resumer)this.all.get(d.subByte);
/*     */   }
/*     */   
/*     */   class Success
/*     */     extends Resumer
/*     */   {
/*     */     public AISTATE res(Humanoid a, AIManager d) {
/* 276 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public AISTATE resI(Humanoid a, AIManager d, HEvent event) {
/* 281 */       return (AI.STATES()).STAND.activate(a, d, 0.20000000298023224D);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean success(Humanoid a, AIManager d) {
/* 286 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public AISTATE setAction(Humanoid a, AIManager d) {
/* 291 */       return (AI.STATES()).STAND.activate(a, d, 0.20000000298023224D);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   class Fail
/*     */     extends Resumer
/*     */   {
/*     */     public AISTATE res(Humanoid a, AIManager d) {
/* 300 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public AISTATE resI(Humanoid a, AIManager d, HEvent event) {
/* 305 */       return (AI.STATES()).STAND.activate(a, d, 0.20000000298023224D);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean success(Humanoid a, AIManager d) {
/* 310 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public AISTATE setAction(Humanoid a, AIManager d) {
/* 315 */       return (AI.STATES()).STAND.activate(a, d, 0.20000000298023224D);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISUB$Resumable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */