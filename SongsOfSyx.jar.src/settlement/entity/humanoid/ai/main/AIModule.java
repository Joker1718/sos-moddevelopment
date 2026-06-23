/*    */ package settlement.entity.humanoid.ai.main;
/*    */ 
/*    */ import game.GameDisposable;
/*    */ import init.type.HTYPE;
/*    */ import init.type.HTYPES;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.room.main.ROOMA;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.Bitmap1D;
/*    */ import snake2d.util.sets.INDEXED;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ 
/*    */ public abstract class AIModule
/*    */   implements INDEXED
/*    */ {
/* 16 */   static final ArrayList<AIModule> all = new ArrayList(200); final byte index; public final CharSequence name;
/*    */   public AIModule(SPRITE icon, CharSequence name, CharSequence desc) {
/* 18 */     all.add(null);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 36 */     this.hasType = new Bitmap1D(HTYPES.ALL().size(), false);
/*    */ 
/*    */     
/* 39 */     this.index = (byte)all.add(this);
/* 40 */     if (this.index < 0)
/* 41 */       throw new RuntimeException(); 
/* 42 */     this.icon = icon;
/* 43 */     this.name = name;
/* 44 */     this.desc = desc;
/*    */   }
/*    */   public final CharSequence desc; private final SPRITE icon; final Bitmap1D hasType;
/*    */   public boolean has(HTYPE t) {
/* 48 */     return this.hasType.get(t.index());
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract AIPLAN.AiPlanActivation getPlan(Humanoid paramHumanoid, AIManager paramAIManager);
/*    */ 
/*    */   
/*    */   protected void init(Humanoid a, AIManager d, HTYPE prev, HTYPE current) {}
/*    */ 
/*    */   
/*    */   protected void cancel(Humanoid a, AIManager d) {}
/*    */ 
/*    */   
/*    */   protected void finish(Humanoid a, AIManager d) {}
/*    */   
/*    */   protected abstract void update(Humanoid paramHumanoid, AIManager paramAIManager, boolean paramBoolean, int paramInt1, int paramInt2);
/*    */   
/*    */   public abstract int getPriority(Humanoid paramHumanoid, AIManager paramAIManager);
/*    */   
/*    */   public AIPLAN.AiPlanActivation resume(Humanoid a, AIManager d, int timesResumedBefore) {
/* 68 */     return null;
/*    */   }
/*    */   
/*    */   public final boolean is(Humanoid a, AIManager d) {
/* 72 */     return (AIModules.current(d) == this);
/*    */   }
/*    */   
/*    */   public final boolean moduleCanContinue(Humanoid a, AIManager d) {
/* 76 */     AIModule m = AIModules.next(d);
/* 77 */     return !(m != null && m != this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void evictFromRoom(Humanoid a, AIManager d, ROOMA r) {}
/*    */ 
/*    */   
/*    */   public int index() {
/* 86 */     return this.index;
/*    */   }
/*    */   
/*    */   public SPRITE icon() {
/* 90 */     return this.icon;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIModule.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */