/*     */ package game.event.engine;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import game.event.actions.EventAction;
/*     */ import game.event.actions.EventActions;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ public final class Event
/*     */ {
/*  17 */   static final ArrayListGrower<Event> all = new ArrayListGrower();
/*     */   
/*     */   int savedIndex;
/*     */   
/*     */   public final int allIndex;
/*     */   
/*     */   public final String key;
/*     */   
/*     */   public ETags tags;
/*     */   
/*     */   public EOccurence occurence;
/*     */   
/*     */   public EInfo info;
/*     */   
/*     */   public EDuration duration;
/*     */   
/*     */   public ESelection selection;
/*     */   
/*     */   public ECondition condition;
/*     */   
/*     */   public LIST<EChoice> choices;
/*     */   
/*     */   public LIST<EventAction> on_spawn;
/*     */   
/*     */   public LIST<ECondition> aborters;
/*     */   
/*  43 */   final ArrayListGrower<EventAction> allActions = new ArrayListGrower();
/*     */   
/*     */   Event(LISTE<Event> coll, String key, Json data, Json text) throws IOException {
/*  46 */     this.key = key;
/*  47 */     this.allIndex = all.add(this);
/*  48 */     if (this.allIndex >= 32767)
/*  49 */       throw new RuntimeException("Too many events!"); 
/*  50 */     this.savedIndex = this.allIndex;
/*  51 */     this.info = new EInfo(data, text);
/*     */     
/*  53 */     coll.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void read(Json data, Json text, EventActions actions, EventCollection engine) {
/*  58 */     this.on_spawn = EActions.actions("ON_SPAWN", this, null, actions, data, false);
/*  59 */     this.occurence = new EOccurence(data, engine, this);
/*  60 */     this.duration = new EDuration(data, actions, this);
/*  61 */     data.has("ICON");
/*     */     
/*  63 */     this.tags = new ETags(data);
/*     */     
/*  65 */     if (data.has("CHOICES")) {
/*  66 */       String[] arrayOfString; Json[] js = data.jsons("CHOICES");
/*     */ 
/*     */       
/*  69 */       if (js.length == 0) {
/*  70 */         CharSequence[] names = new CharSequence[0];
/*  71 */       } else if (text == null || !text.has("CHOICES")) {
/*  72 */         if (js.length <= 2) {
/*  73 */           CharSequence[] names = {
/*  74 */               Dic.¤¤Accept, 
/*  75 */               Dic.¤¤Decline
/*     */             };
/*     */         } else {
/*  78 */           CharSequence[] names = new CharSequence[0];
/*     */         } 
/*     */       } else {
/*  81 */         arrayOfString = text.texts("CHOICES");
/*     */       } 
/*     */       
/*  84 */       ArrayList<EChoice> cs = new ArrayList(js.length);
/*     */       
/*  86 */       for (int i = 0; i < js.length; i++) {
/*  87 */         cs.add(new EChoice(this, i, actions, js[i], (i < arrayOfString.length) ? arrayOfString[i] : ("" + i)));
/*     */       }
/*  89 */       this.choices = (LIST<EChoice>)cs;
/*     */     } else {
/*  91 */       this.choices = (LIST<EChoice>)new ArrayList(0);
/*     */     } 
/*  93 */     if (data.has("CONDITION"))
/*     */     {
/*  95 */       this.condition = new ECondition("CONDITION", data, actions, this);
/*     */     }
/*  97 */     if (data.has("ABORTS")) {
/*  98 */       Json[] jj = data.jsons("ABORTS", 0);
/*  99 */       ArrayList<ECondition> aborters = new ArrayList(jj.length); byte b; int i; Json[] arrayOfJson1;
/* 100 */       for (i = (arrayOfJson1 = jj).length, b = 0; b < i; ) { Json j = arrayOfJson1[b];
/* 101 */         aborters.add(new ECondition(null, j, actions, this)); b++; }
/*     */       
/* 103 */       this.aborters = (LIST<ECondition>)aborters;
/*     */     } else {
/* 105 */       this.aborters = (LIST<ECondition>)new ArrayList(0);
/*     */     } 
/*     */ 
/*     */     
/* 109 */     this.selection = new ESelection(this, actions, data);
/* 110 */     data.checkUnused();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<EventAction> actions() {
/* 124 */     return (LIST<EventAction>)this.allActions;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\Event.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */