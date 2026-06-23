/*     */ package org.lwjgl.system.linux;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
/*     */ import org.lwjgl.system.Struct;
/*     */ import org.lwjgl.system.StructBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XEvent
/*     */   extends Struct<XEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int XANY;
/*     */   public static final int XKEY;
/*     */   public static final int XBUTTON;
/*     */   public static final int XMOTION;
/*     */   public static final int XCROSSING;
/*     */   public static final int XFOCUS;
/*     */   public static final int XEXPOSE;
/*     */   public static final int XGRAPHICSEXPOSE;
/*     */   public static final int XNOEXPOSE;
/*     */   public static final int XVISIBILITY;
/*     */   public static final int XCREATEWINDOW;
/*     */   public static final int XDESTROYWINDOW;
/*     */   public static final int XUNMAP;
/*     */   public static final int XMAP;
/*     */   public static final int XMAPREQUEST;
/*     */   public static final int XREPARENT;
/*     */   public static final int XCONFIGURE;
/*     */   public static final int XGRAVITY;
/*     */   public static final int XRESIZEREQUEST;
/*     */   public static final int XCONFIGUREREQUEST;
/*     */   public static final int XCIRCULATE;
/*     */   public static final int XCIRCULATEREQUEST;
/*     */   public static final int XPROPERTY;
/*     */   public static final int XSELECTIONCLEAR;
/*     */   public static final int XSELECTIONREQUEST;
/*     */   public static final int XSELECTION;
/*     */   public static final int XCOLORMAP;
/*     */   public static final int XCLIENT;
/*     */   public static final int XMAPPING;
/*     */   public static final int XERROR;
/*     */   public static final int XKEYMAP;
/*     */   public static final int XGENERIC;
/*     */   public static final int XCOOKIE;
/*     */   
/*     */   static {
/* 104 */     Struct.Layout layout = __union(new Struct.Member[] { 
/* 105 */           __member(4), 
/* 106 */           __member(XAnyEvent.SIZEOF, XAnyEvent.ALIGNOF), 
/* 107 */           __member(XKeyEvent.SIZEOF, XKeyEvent.ALIGNOF), 
/* 108 */           __member(XButtonEvent.SIZEOF, XButtonEvent.ALIGNOF), 
/* 109 */           __member(XMotionEvent.SIZEOF, XMotionEvent.ALIGNOF), 
/* 110 */           __member(XCrossingEvent.SIZEOF, XCrossingEvent.ALIGNOF), 
/* 111 */           __member(XFocusChangeEvent.SIZEOF, XFocusChangeEvent.ALIGNOF), 
/* 112 */           __member(XExposeEvent.SIZEOF, XExposeEvent.ALIGNOF), 
/* 113 */           __member(XGraphicsExposeEvent.SIZEOF, XGraphicsExposeEvent.ALIGNOF), 
/* 114 */           __member(XNoExposeEvent.SIZEOF, XNoExposeEvent.ALIGNOF), 
/* 115 */           __member(XVisibilityEvent.SIZEOF, XVisibilityEvent.ALIGNOF), 
/* 116 */           __member(XCreateWindowEvent.SIZEOF, XCreateWindowEvent.ALIGNOF), 
/* 117 */           __member(XDestroyWindowEvent.SIZEOF, XDestroyWindowEvent.ALIGNOF), 
/* 118 */           __member(XUnmapEvent.SIZEOF, XUnmapEvent.ALIGNOF), 
/* 119 */           __member(XMapEvent.SIZEOF, XMapEvent.ALIGNOF), 
/* 120 */           __member(XMapRequestEvent.SIZEOF, XMapRequestEvent.ALIGNOF), 
/* 121 */           __member(XReparentEvent.SIZEOF, XReparentEvent.ALIGNOF), 
/* 122 */           __member(XConfigureEvent.SIZEOF, XConfigureEvent.ALIGNOF), 
/* 123 */           __member(XGravityEvent.SIZEOF, XGravityEvent.ALIGNOF), 
/* 124 */           __member(XResizeRequestEvent.SIZEOF, XResizeRequestEvent.ALIGNOF), 
/* 125 */           __member(XConfigureRequestEvent.SIZEOF, XConfigureRequestEvent.ALIGNOF), 
/* 126 */           __member(XCirculateEvent.SIZEOF, XCirculateEvent.ALIGNOF), 
/* 127 */           __member(XCirculateRequestEvent.SIZEOF, XCirculateRequestEvent.ALIGNOF), 
/* 128 */           __member(XPropertyEvent.SIZEOF, XPropertyEvent.ALIGNOF), 
/* 129 */           __member(XSelectionClearEvent.SIZEOF, XSelectionClearEvent.ALIGNOF), 
/* 130 */           __member(XSelectionRequestEvent.SIZEOF, XSelectionRequestEvent.ALIGNOF), 
/* 131 */           __member(XSelectionEvent.SIZEOF, XSelectionEvent.ALIGNOF), 
/* 132 */           __member(XColormapEvent.SIZEOF, XColormapEvent.ALIGNOF), 
/* 133 */           __member(XClientMessageEvent.SIZEOF, XClientMessageEvent.ALIGNOF), 
/* 134 */           __member(XMappingEvent.SIZEOF, XMappingEvent.ALIGNOF), 
/* 135 */           __member(XErrorEvent.SIZEOF, XErrorEvent.ALIGNOF), 
/* 136 */           __member(XKeymapEvent.SIZEOF, XKeymapEvent.ALIGNOF), 
/* 137 */           __member(XGenericEvent.SIZEOF, XGenericEvent.ALIGNOF), 
/* 138 */           __member(XGenericEventCookie.SIZEOF, XGenericEventCookie.ALIGNOF), 
/* 139 */           __padding(24, CLONG_SIZE, true) });
/*     */ 
/*     */     
/* 142 */     SIZEOF = layout.getSize();
/* 143 */     ALIGNOF = layout.getAlignment();
/*     */     
/* 145 */     TYPE = layout.offsetof(0);
/* 146 */     XANY = layout.offsetof(1);
/* 147 */     XKEY = layout.offsetof(2);
/* 148 */     XBUTTON = layout.offsetof(3);
/* 149 */     XMOTION = layout.offsetof(4);
/* 150 */     XCROSSING = layout.offsetof(5);
/* 151 */     XFOCUS = layout.offsetof(6);
/* 152 */     XEXPOSE = layout.offsetof(7);
/* 153 */     XGRAPHICSEXPOSE = layout.offsetof(8);
/* 154 */     XNOEXPOSE = layout.offsetof(9);
/* 155 */     XVISIBILITY = layout.offsetof(10);
/* 156 */     XCREATEWINDOW = layout.offsetof(11);
/* 157 */     XDESTROYWINDOW = layout.offsetof(12);
/* 158 */     XUNMAP = layout.offsetof(13);
/* 159 */     XMAP = layout.offsetof(14);
/* 160 */     XMAPREQUEST = layout.offsetof(15);
/* 161 */     XREPARENT = layout.offsetof(16);
/* 162 */     XCONFIGURE = layout.offsetof(17);
/* 163 */     XGRAVITY = layout.offsetof(18);
/* 164 */     XRESIZEREQUEST = layout.offsetof(19);
/* 165 */     XCONFIGUREREQUEST = layout.offsetof(20);
/* 166 */     XCIRCULATE = layout.offsetof(21);
/* 167 */     XCIRCULATEREQUEST = layout.offsetof(22);
/* 168 */     XPROPERTY = layout.offsetof(23);
/* 169 */     XSELECTIONCLEAR = layout.offsetof(24);
/* 170 */     XSELECTIONREQUEST = layout.offsetof(25);
/* 171 */     XSELECTION = layout.offsetof(26);
/* 172 */     XCOLORMAP = layout.offsetof(27);
/* 173 */     XCLIENT = layout.offsetof(28);
/* 174 */     XMAPPING = layout.offsetof(29);
/* 175 */     XERROR = layout.offsetof(30);
/* 176 */     XKEYMAP = layout.offsetof(31);
/* 177 */     XGENERIC = layout.offsetof(32);
/* 178 */     XCOOKIE = layout.offsetof(33);
/*     */   }
/*     */   
/*     */   protected XEvent(long address, ByteBuffer container) {
/* 182 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XEvent create(long address, ByteBuffer container) {
/* 187 */     return new XEvent(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XEvent(ByteBuffer container) {
/* 197 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 201 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 204 */     return ntype(address());
/*     */   } public XAnyEvent xany() {
/* 206 */     return nxany(address());
/*     */   } public XKeyEvent xkey() {
/* 208 */     return nxkey(address());
/*     */   } public XButtonEvent xbutton() {
/* 210 */     return nxbutton(address());
/*     */   } public XMotionEvent xmotion() {
/* 212 */     return nxmotion(address());
/*     */   } public XCrossingEvent xcrossing() {
/* 214 */     return nxcrossing(address());
/*     */   } public XFocusChangeEvent xfocus() {
/* 216 */     return nxfocus(address());
/*     */   } public XExposeEvent xexpose() {
/* 218 */     return nxexpose(address());
/*     */   } public XGraphicsExposeEvent xgraphicsexpose() {
/* 220 */     return nxgraphicsexpose(address());
/*     */   } public XNoExposeEvent xnoexpose() {
/* 222 */     return nxnoexpose(address());
/*     */   } public XVisibilityEvent xvisibility() {
/* 224 */     return nxvisibility(address());
/*     */   } public XCreateWindowEvent xcreatewindow() {
/* 226 */     return nxcreatewindow(address());
/*     */   } public XDestroyWindowEvent xdestroywindow() {
/* 228 */     return nxdestroywindow(address());
/*     */   } public XUnmapEvent xunmap() {
/* 230 */     return nxunmap(address());
/*     */   } public XMapEvent xmap() {
/* 232 */     return nxmap(address());
/*     */   } public XMapRequestEvent xmaprequest() {
/* 234 */     return nxmaprequest(address());
/*     */   } public XReparentEvent xreparent() {
/* 236 */     return nxreparent(address());
/*     */   } public XConfigureEvent xconfigure() {
/* 238 */     return nxconfigure(address());
/*     */   } public XGravityEvent xgravity() {
/* 240 */     return nxgravity(address());
/*     */   } public XResizeRequestEvent xresizerequest() {
/* 242 */     return nxresizerequest(address());
/*     */   } public XConfigureRequestEvent xconfigurerequest() {
/* 244 */     return nxconfigurerequest(address());
/*     */   } public XCirculateEvent xcirculate() {
/* 246 */     return nxcirculate(address());
/*     */   } public XCirculateRequestEvent xcirculaterequest() {
/* 248 */     return nxcirculaterequest(address());
/*     */   } public XPropertyEvent xproperty() {
/* 250 */     return nxproperty(address());
/*     */   } public XSelectionClearEvent xselectionclear() {
/* 252 */     return nxselectionclear(address());
/*     */   } public XSelectionRequestEvent xselectionrequest() {
/* 254 */     return nxselectionrequest(address());
/*     */   } public XSelectionEvent xselection() {
/* 256 */     return nxselection(address());
/*     */   } public XColormapEvent xcolormap() {
/* 258 */     return nxcolormap(address());
/*     */   } public XClientMessageEvent xclient() {
/* 260 */     return nxclient(address());
/*     */   } public XMappingEvent xmapping() {
/* 262 */     return nxmapping(address());
/*     */   } public XErrorEvent xerror() {
/* 264 */     return nxerror(address());
/*     */   } public XKeymapEvent xkeymap() {
/* 266 */     return nxkeymap(address());
/*     */   } public XGenericEvent xgeneric() {
/* 268 */     return nxgeneric(address());
/*     */   } public XGenericEventCookie xcookie() {
/* 270 */     return nxcookie(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XEvent malloc() {
/* 276 */     return new XEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XEvent calloc() {
/* 281 */     return new XEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XEvent create() {
/* 286 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 287 */     return new XEvent(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XEvent create(long address) {
/* 292 */     return new XEvent(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XEvent createSafe(long address) {
/* 297 */     return (address == 0L) ? null : new XEvent(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 306 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 315 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 324 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 325 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 335 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 340 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XEvent malloc(MemoryStack stack) {
/* 349 */     return new XEvent(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XEvent calloc(MemoryStack stack) {
/* 358 */     return new XEvent(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 368 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 378 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long struct) {
/* 384 */     return MemoryUtil.memGetInt(struct + TYPE);
/*     */   } public static XAnyEvent nxany(long struct) {
/* 386 */     return XAnyEvent.create(struct + XANY);
/*     */   } public static XKeyEvent nxkey(long struct) {
/* 388 */     return XKeyEvent.create(struct + XKEY);
/*     */   } public static XButtonEvent nxbutton(long struct) {
/* 390 */     return XButtonEvent.create(struct + XBUTTON);
/*     */   } public static XMotionEvent nxmotion(long struct) {
/* 392 */     return XMotionEvent.create(struct + XMOTION);
/*     */   } public static XCrossingEvent nxcrossing(long struct) {
/* 394 */     return XCrossingEvent.create(struct + XCROSSING);
/*     */   } public static XFocusChangeEvent nxfocus(long struct) {
/* 396 */     return XFocusChangeEvent.create(struct + XFOCUS);
/*     */   } public static XExposeEvent nxexpose(long struct) {
/* 398 */     return XExposeEvent.create(struct + XEXPOSE);
/*     */   } public static XGraphicsExposeEvent nxgraphicsexpose(long struct) {
/* 400 */     return XGraphicsExposeEvent.create(struct + XGRAPHICSEXPOSE);
/*     */   } public static XNoExposeEvent nxnoexpose(long struct) {
/* 402 */     return XNoExposeEvent.create(struct + XNOEXPOSE);
/*     */   } public static XVisibilityEvent nxvisibility(long struct) {
/* 404 */     return XVisibilityEvent.create(struct + XVISIBILITY);
/*     */   } public static XCreateWindowEvent nxcreatewindow(long struct) {
/* 406 */     return XCreateWindowEvent.create(struct + XCREATEWINDOW);
/*     */   } public static XDestroyWindowEvent nxdestroywindow(long struct) {
/* 408 */     return XDestroyWindowEvent.create(struct + XDESTROYWINDOW);
/*     */   } public static XUnmapEvent nxunmap(long struct) {
/* 410 */     return XUnmapEvent.create(struct + XUNMAP);
/*     */   } public static XMapEvent nxmap(long struct) {
/* 412 */     return XMapEvent.create(struct + XMAP);
/*     */   } public static XMapRequestEvent nxmaprequest(long struct) {
/* 414 */     return XMapRequestEvent.create(struct + XMAPREQUEST);
/*     */   } public static XReparentEvent nxreparent(long struct) {
/* 416 */     return XReparentEvent.create(struct + XREPARENT);
/*     */   } public static XConfigureEvent nxconfigure(long struct) {
/* 418 */     return XConfigureEvent.create(struct + XCONFIGURE);
/*     */   } public static XGravityEvent nxgravity(long struct) {
/* 420 */     return XGravityEvent.create(struct + XGRAVITY);
/*     */   } public static XResizeRequestEvent nxresizerequest(long struct) {
/* 422 */     return XResizeRequestEvent.create(struct + XRESIZEREQUEST);
/*     */   } public static XConfigureRequestEvent nxconfigurerequest(long struct) {
/* 424 */     return XConfigureRequestEvent.create(struct + XCONFIGUREREQUEST);
/*     */   } public static XCirculateEvent nxcirculate(long struct) {
/* 426 */     return XCirculateEvent.create(struct + XCIRCULATE);
/*     */   } public static XCirculateRequestEvent nxcirculaterequest(long struct) {
/* 428 */     return XCirculateRequestEvent.create(struct + XCIRCULATEREQUEST);
/*     */   } public static XPropertyEvent nxproperty(long struct) {
/* 430 */     return XPropertyEvent.create(struct + XPROPERTY);
/*     */   } public static XSelectionClearEvent nxselectionclear(long struct) {
/* 432 */     return XSelectionClearEvent.create(struct + XSELECTIONCLEAR);
/*     */   } public static XSelectionRequestEvent nxselectionrequest(long struct) {
/* 434 */     return XSelectionRequestEvent.create(struct + XSELECTIONREQUEST);
/*     */   } public static XSelectionEvent nxselection(long struct) {
/* 436 */     return XSelectionEvent.create(struct + XSELECTION);
/*     */   } public static XColormapEvent nxcolormap(long struct) {
/* 438 */     return XColormapEvent.create(struct + XCOLORMAP);
/*     */   } public static XClientMessageEvent nxclient(long struct) {
/* 440 */     return XClientMessageEvent.create(struct + XCLIENT);
/*     */   } public static XMappingEvent nxmapping(long struct) {
/* 442 */     return XMappingEvent.create(struct + XMAPPING);
/*     */   } public static XErrorEvent nxerror(long struct) {
/* 444 */     return XErrorEvent.create(struct + XERROR);
/*     */   } public static XKeymapEvent nxkeymap(long struct) {
/* 446 */     return XKeymapEvent.create(struct + XKEYMAP);
/*     */   } public static XGenericEvent nxgeneric(long struct) {
/* 448 */     return XGenericEvent.create(struct + XGENERIC);
/*     */   } public static XGenericEventCookie nxcookie(long struct) {
/* 450 */     return XGenericEventCookie.create(struct + XCOOKIE);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 457 */     private static final XEvent ELEMENT_FACTORY = XEvent.create(-1L);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Buffer(ByteBuffer container) {
/* 469 */       super(container, container.remaining() / XEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 473 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 477 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 482 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 487 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XEvent getElementFactory() {
/* 492 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 496 */       return XEvent.ntype(address());
/*     */     } public XAnyEvent xany() {
/* 498 */       return XEvent.nxany(address());
/*     */     } public XKeyEvent xkey() {
/* 500 */       return XEvent.nxkey(address());
/*     */     } public XButtonEvent xbutton() {
/* 502 */       return XEvent.nxbutton(address());
/*     */     } public XMotionEvent xmotion() {
/* 504 */       return XEvent.nxmotion(address());
/*     */     } public XCrossingEvent xcrossing() {
/* 506 */       return XEvent.nxcrossing(address());
/*     */     } public XFocusChangeEvent xfocus() {
/* 508 */       return XEvent.nxfocus(address());
/*     */     } public XExposeEvent xexpose() {
/* 510 */       return XEvent.nxexpose(address());
/*     */     } public XGraphicsExposeEvent xgraphicsexpose() {
/* 512 */       return XEvent.nxgraphicsexpose(address());
/*     */     } public XNoExposeEvent xnoexpose() {
/* 514 */       return XEvent.nxnoexpose(address());
/*     */     } public XVisibilityEvent xvisibility() {
/* 516 */       return XEvent.nxvisibility(address());
/*     */     } public XCreateWindowEvent xcreatewindow() {
/* 518 */       return XEvent.nxcreatewindow(address());
/*     */     } public XDestroyWindowEvent xdestroywindow() {
/* 520 */       return XEvent.nxdestroywindow(address());
/*     */     } public XUnmapEvent xunmap() {
/* 522 */       return XEvent.nxunmap(address());
/*     */     } public XMapEvent xmap() {
/* 524 */       return XEvent.nxmap(address());
/*     */     } public XMapRequestEvent xmaprequest() {
/* 526 */       return XEvent.nxmaprequest(address());
/*     */     } public XReparentEvent xreparent() {
/* 528 */       return XEvent.nxreparent(address());
/*     */     } public XConfigureEvent xconfigure() {
/* 530 */       return XEvent.nxconfigure(address());
/*     */     } public XGravityEvent xgravity() {
/* 532 */       return XEvent.nxgravity(address());
/*     */     } public XResizeRequestEvent xresizerequest() {
/* 534 */       return XEvent.nxresizerequest(address());
/*     */     } public XConfigureRequestEvent xconfigurerequest() {
/* 536 */       return XEvent.nxconfigurerequest(address());
/*     */     } public XCirculateEvent xcirculate() {
/* 538 */       return XEvent.nxcirculate(address());
/*     */     } public XCirculateRequestEvent xcirculaterequest() {
/* 540 */       return XEvent.nxcirculaterequest(address());
/*     */     } public XPropertyEvent xproperty() {
/* 542 */       return XEvent.nxproperty(address());
/*     */     } public XSelectionClearEvent xselectionclear() {
/* 544 */       return XEvent.nxselectionclear(address());
/*     */     } public XSelectionRequestEvent xselectionrequest() {
/* 546 */       return XEvent.nxselectionrequest(address());
/*     */     } public XSelectionEvent xselection() {
/* 548 */       return XEvent.nxselection(address());
/*     */     } public XColormapEvent xcolormap() {
/* 550 */       return XEvent.nxcolormap(address());
/*     */     } public XClientMessageEvent xclient() {
/* 552 */       return XEvent.nxclient(address());
/*     */     } public XMappingEvent xmapping() {
/* 554 */       return XEvent.nxmapping(address());
/*     */     } public XErrorEvent xerror() {
/* 556 */       return XEvent.nxerror(address());
/*     */     } public XKeymapEvent xkeymap() {
/* 558 */       return XEvent.nxkeymap(address());
/*     */     } public XGenericEvent xgeneric() {
/* 560 */       return XEvent.nxgeneric(address());
/*     */     } public XGenericEventCookie xcookie() {
/* 562 */       return XEvent.nxcookie(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\XEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */