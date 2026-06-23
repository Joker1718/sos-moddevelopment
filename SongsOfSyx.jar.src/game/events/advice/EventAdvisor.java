/*     */ package game.events.advice;
/*     */ 
/*     */ import game.events.EVENTS;
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ import view.sett.UISettMap;
/*     */ import view.ui.message.MessageSection;
/*     */ 
/*     */ 
/*     */ public final class EventAdvisor
/*     */   extends EVENTS.EventResource
/*     */ {
/*     */   private boolean toggled = true;
/*  29 */   private double timer = 5.0D;
/*  30 */   private LinkedList<Advice> all = new LinkedList();
/*  31 */   private LinkedList<Advice> active = new LinkedList();
/*     */   
/*  33 */   private static CharSequence ¤¤Advice = "Advisor: ";
/*     */   
/*     */   static {
/*  36 */     D.ts(EventAdvisor.class);
/*     */   }
/*     */   
/*     */   public EventAdvisor() {
/*  40 */     super("ADVICE");
/*  41 */     Json json = new Json(PATHS.TEXT_MISC().gets("Advice"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  89 */     for (Advice a : this.all) {
/*  90 */       this.active.add(a);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/*  96 */     if (!this.toggled)
/*     */       return; 
/*  98 */     if (!VIEW.s().isActive()) {
/*  99 */       this.timer = 3.0D;
/*     */       return;
/*     */     } 
/* 102 */     this.timer -= ds;
/* 103 */     if (this.timer < 0.0D) {
/* 104 */       this.timer += 5.0D;
/* 105 */       for (Advice a : this.active) {
/* 106 */         if (a.send()) {
/* 107 */           this.active.remove(a);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 116 */     file.i(this.active.size());
/* 117 */     for (Advice a : this.active) {
/* 118 */       file.i(a.index);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 123 */     this.active.clear();
/* 124 */     int k = file.i();
/* 125 */     for (int i = 0; i < k; i++) {
/* 126 */       int q = file.i();
/* 127 */       if (q >= 0 && q < this.all.size()) {
/* 128 */         this.active.add(this.all.get(q));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 135 */     this.active.clear();
/* 136 */     for (Advice a : this.all) {
/* 137 */       this.active.add(a);
/*     */     }
/*     */   }
/*     */   
/*     */   public abstract class Advice
/*     */   {
/*     */     private final int index;
/*     */     
/*     */     Advice() {
/* 146 */       this.index = EventAdvisor.this.all.add(this);
/*     */     }
/*     */     
/*     */     public abstract boolean send();
/*     */   }
/*     */   
/*     */   public abstract class AdviceHighlight
/*     */     extends Advice
/*     */   {
/*     */     private final String keyButt;
/*     */     private final INFO info;
/*     */     
/*     */     AdviceHighlight(String keyButt, String keyj, Json json) {
/* 159 */       this.keyButt = keyButt;
/* 160 */       UISettMap.getByKey(keyButt);
/* 161 */       this.info = new INFO(json.json(keyj));
/*     */     }
/*     */ 
/*     */     
/*     */     public abstract boolean shouldsend();
/*     */ 
/*     */     
/*     */     public boolean send() {
/* 169 */       if (shouldsend()) {
/* 170 */         (new EventAdvisor.MessageHighlight(this.info.name, this.info.desc, this.keyButt)).send();
/* 171 */         return true;
/*     */       } 
/* 173 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class MessageHighlight
/*     */     extends MessageSection
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private final String UIKey;
/*     */     
/*     */     private final String body;
/*     */     
/*     */     public MessageHighlight(CharSequence title, CharSequence body, String UIKey) {
/* 188 */       super(String.valueOf(EventAdvisor.¤¤Advice) + String.valueOf(EventAdvisor.¤¤Advice));
/* 189 */       this.UIKey = UIKey;
/* 190 */       this.body = String.valueOf(body);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void make(final GuiSection section) {
/* 195 */       paragraph(this.body);
/*     */       
/* 197 */       section.addDown(0, (RENDEROBJ)new RENDEROBJ.RenderImp(0) {
/* 198 */             final RENDEROBJ o = UISettMap.getByKey(EventAdvisor.MessageHighlight.this.UIKey);
/*     */             
/*     */             public void render(SPRITE_RENDERER r, float ds) {
/* 201 */               EventAdvisor.MessageHighlight.highlight(section, r, this.o);
/* 202 */               if (!VIEW.s().isActive()) {
/* 203 */                 VIEW.s().activate();
/*     */               }
/*     */             }
/*     */           });
/*     */     }
/*     */     
/*     */     private static void highlight(GuiSection s, SPRITE_RENDERER r, RENDEROBJ o) {
/* 210 */       COLOR c = COLOR.RED2RED;
/*     */       
/* 212 */       c.render(r, o.body().x1() - 8, o.body().x2() + 8, o.body().y1() - 8, o.body().y1() - 4);
/* 213 */       c.render(r, o.body().x1() - 8, o.body().x2() + 8, o.body().y2() + 8, o.body().y2() + 4);
/* 214 */       c.render(r, o.body().x1() - 8, o.body().x1() - 4, o.body().y1() - 8, o.body().y2() + 8);
/* 215 */       c.render(r, o.body().x2() + 4, o.body().x2() + 8, o.body().y1() - 8, o.body().y2() + 8);
/*     */ 
/*     */ 
/*     */       
/* 219 */       if (o.body().cX() < s.body().cX()) {
/* 220 */         c.render(r, o.body().x2() + 4, s.body().cX() + 4, o.body().cY() - 4, o.body().cY() + 4);
/*     */       } else {
/* 222 */         c.render(r, o.body().x1() - 4, s.body().cX() + 4, o.body().cY() - 4, o.body().cY() + 4);
/*     */       } 
/*     */       
/* 225 */       int y1 = s.body().y1() - 80;
/* 226 */       int y2 = s.body().y2();
/*     */       
/* 228 */       if (o.body().y2() < y1) {
/* 229 */         c.render(r, s.body().cX() - 4, s.body().cX() + 4, o.body().cY(), y1);
/*     */       } else {
/* 231 */         c.render(r, s.body().cX() - 4, s.body().cX() + 4, o.body().cY(), y2);
/*     */       } 
/*     */ 
/*     */       
/* 235 */       OPACITY.unbind();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\advice\EventAdvisor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */